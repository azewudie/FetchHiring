package com.aaron.fetch.framework.baseviewmodel

import androidx.lifecycle.ViewModel
import com.aaron.fetch.data.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(
    private val dataRepository: DataRepository
): ViewModel(){
}