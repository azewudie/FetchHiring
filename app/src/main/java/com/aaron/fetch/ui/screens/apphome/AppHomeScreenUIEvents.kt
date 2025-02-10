package com.aaron.fetch.ui.screens.apphome


sealed class AppHomeScreenUIEvents {
    data object GetInitialData : AppHomeScreenUIEvents()
    data class OnClickedGroup(val index: Int? = null) : AppHomeScreenUIEvents()
}