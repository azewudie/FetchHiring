package com.aaron.fetch.ui.common.screenstate

sealed class UIState{
    data object Success: UIState()
    data object Loading : UIState()
    data object Error : UIState()
}
