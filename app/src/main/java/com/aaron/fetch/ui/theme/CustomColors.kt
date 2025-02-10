package com.aaron.fetch.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class CustomColors(
    val text0: Color,
    val textWhite: Color,
    val backGrounds: Color,
    val cardDefault: Color,
    val logoColor:Color
)

val LocalColors = staticCompositionLocalOf {
    CustomColors(
        text0 = Color.Unspecified,
        textWhite = Color.Unspecified,
        backGrounds = Color.Unspecified,
        cardDefault = Color.Unspecified,
        logoColor = Color.Unspecified
    )
}