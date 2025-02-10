package com.aaron.fetch.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

data class CustomTypography(
    val title0Regular: TextStyle,
    val largeTitleRegular:TextStyle,
    val titleBold: TextStyle,
)

val LocalTypography = staticCompositionLocalOf {
    CustomTypography(
        title0Regular = TextStyle.Default,
        largeTitleRegular = TextStyle.Default,
        titleBold = TextStyle.Default,
    )
}