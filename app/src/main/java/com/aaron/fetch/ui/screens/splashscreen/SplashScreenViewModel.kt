package com.aaron.fetch.ui.screens.splashscreen

import com.aaron.fetch.di.appresources.AppResources
import com.aaron.fetch.R
import com.aaron.fetch.data.DataRepository
import com.aaron.fetch.framework.baseviewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val appResources: AppResources,
    dataRepository: DataRepository
) : BaseViewModel(dataRepository) {
    private val _screenState = MutableStateFlow(getUiInitialState())
    val screenState = _screenState.asStateFlow()

    private fun getUiInitialState(): SplashScreenUIStates {
        return SplashScreenUIStates(
            appLogo = appResources.getString(R.string.app_logo),
            appHeaderText = appResources.getString(R.string.app_header_text)
        )
    }
}