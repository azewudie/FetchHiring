package com.aaron.fetch.ui.screens.apphome

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.aaron.fetch.di.appresources.AppResources
import com.aaron.fetch.R
import com.aaron.fetch.data.DataRepository
import com.aaron.fetch.data.remote.MainResponse
import com.aaron.fetch.framework.baseviewmodel.BaseViewModel
import com.aaron.fetch.ui.common.screenstate.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppHomeScreenViewModel @Inject constructor(
    private val appResources: AppResources,
    private val dataRepository: DataRepository
) : BaseViewModel(dataRepository) {
    private val _screenState = MutableStateFlow(getUiInitialState())
    val screenState = _screenState.asStateFlow()
    private val _progressState = MutableStateFlow<UIState>(UIState.Success)
    val progressState = _progressState.asStateFlow()

    private fun getUiInitialState(): AppHomeScreenUIStates {
        return AppHomeScreenUIStates(
            appHomeHeader = appResources.getString(R.string.app_home_header),
            appHomeGroupTab = appResources.getString(R.string.app_home_group_tab)
        )
    }

    fun onAppHomeScreenEvent(events: AppHomeScreenUIEvents) {
        when (events) {
            is AppHomeScreenUIEvents.GetInitialData -> {
                getInitialData()
            }

            is AppHomeScreenUIEvents.OnClickedGroup -> {
                _screenState.update {
                    it.copy(
                        appHomeGroupedIndex = events.index!!
                    )
                }
            }
        }
    }

    private fun getInitialData() {
        viewModelScope.launch {
            _progressState.update { UIState.Loading }
            when (val response = dataRepository.getApplicationApiService().getFetchHiring()) {
                is MainResponse.Success -> {
                    Log.d("API_RESPONSE", "getInitialData: $response")
                    val groupedAndSorted = response.body
                        .filter { !it.name.isNullOrBlank() } // Filter out items with empty or null names if needed
                        .sortedBy { it.listId } // Sort the entire list by listId numerically
                        .groupBy { it.listId } // Group the sorted list by listId
                        .mapValues { (_, items) ->
                            // Sort each group by name (nulls last, or empty name as last)
                            items.sortedBy { it.name ?: "" }
                        }

                    _screenState.update {
                        it.copy(
                            appHomeGroupedAndSortedList = groupedAndSorted
                        )
                    }
                    Log.d("API_RESPONSE", "getInitialData: $groupedAndSorted")
                    _progressState.update { UIState.Success }

                }

                is MainResponse.ApiError -> {
                    Log.d("API_ERROR", "getApiData: Api Error")
                    _progressState.update { UIState.Success }
                }

                is MainResponse.NetworkError -> {
                    Log.d("Network_ERROR", "getApiData: Network Error")
                    _progressState.update { UIState.Success }
                }

                is MainResponse.UnknownError -> {
                    Log.d("UNKNOWN_ERROR", "getApiData: Unknown Error")
                    _progressState.update { UIState.Success }
                }
            }
        }

    }

}