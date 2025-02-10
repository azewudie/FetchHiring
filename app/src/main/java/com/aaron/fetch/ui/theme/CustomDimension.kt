package com.aaron.fetch.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class CustomDimensions(
    val dp0: Dp = 0.dp,
    val dp1: Dp = 1.dp,
    val dp2: Dp = 2.dp,
    val dp4: Dp = 4.dp,
    val dp8: Dp = 8.dp,
    val dp10: Dp = 10.dp,
    val dp12: Dp = 12.dp,
    val dp15: Dp = 15.dp,
    val dp16: Dp = 16.dp,
    val dp13: Dp = 13.dp,
    val dp330: Dp = 330.dp,
)
val LocalDimensions = staticCompositionLocalOf { CustomDimensions() }