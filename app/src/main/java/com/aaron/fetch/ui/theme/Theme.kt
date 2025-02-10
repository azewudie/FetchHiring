package com.aaron.fetch.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import com.google.accompanist.systemuicontroller.rememberSystemUiController
private val DarkColorScheme = CustomColors(
    text0 = Color(0xFFF3F3F8),
    textWhite = Color(0xFFF3F3F8),
    backGrounds = Color(0xFF2E0056),
    cardDefault = Color(0xFFB531D8),
    logoColor = Color(0xFF24D692)

)

private val LightColorScheme = CustomColors(
    text0 = Color(0xFF29353A),
    textWhite = Color(0xFFF3F3F8),
    backGrounds = Color(0xFFF3F3F8),
    cardDefault = Color(0xFFFCFCFc),
    logoColor = Color(0xFF23786D)
)

@Composable
fun getColors(): CustomColors {
    return if (isSystemInDarkTheme()) DarkColorScheme else LightColorScheme
}

@Composable
fun getTypography(): CustomTypography {
    return CustomTypography(
        title0Regular = TextStyle(
            fontWeight = FontWeight(700),
            fontSize = 22.sp,
            lineHeight = 17.sp
        ),
        largeTitleRegular = TextStyle(
            fontWeight = FontWeight(400),
            fontSize = 11.sp,
            lineHeight = 13.sp
        ),
        titleBold = TextStyle(
            fontWeight = FontWeight(400),
            fontSize = 11.sp,
            lineHeight = 13.sp
        ),

    )
}

@Composable
fun getDimension(): CustomDimensions {
    return CustomDimensions()
}

@Composable
fun CustomTheme(
    spaces: CustomDimensions = getDimension(),
    typography: CustomTypography = getTypography(),
    colors: CustomColors = getColors(),
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    val darkTheme = isSystemInDarkTheme()
    if (!view.isInEditMode) {
        val systemUiController =rememberSystemUiController()
        SideEffect {
            systemUiController.setStatusBarColor(
                color = colors.backGrounds,
                darkIcons = !darkTheme
            )
        }
    }
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalDimensions provides spaces,
        LocalTypography provides typography
    ) {
        content()
    }

}