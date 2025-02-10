package com.aaron.fetch.ui.screens.apphome

import com.aaron.fetch.data.remote.models.responses.HiringResponseItem
import com.aaron.fetch.utilities.constants.AppConstants

data class AppHomeScreenUIStates(
    val appHomeHeader: String = AppConstants.EMPTY_STRING,
    val appHomeGroupTab: String = AppConstants.EMPTY_STRING,
    val appHomeGroupedAndSortedList: Map<Int?, List<HiringResponseItem>> = mapOf(),
    val appHomeGroupedIndex:Int = 1
    )