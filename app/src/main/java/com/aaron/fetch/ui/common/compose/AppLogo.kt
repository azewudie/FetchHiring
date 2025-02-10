package com.aaron.fetch.ui.common.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaron.fetch.R
import com.aaron.fetch.ui.common.composeattributes.TextAttributes
import com.aaron.fetch.ui.theme.CustomTheme

@Composable
fun AppLogo(
    logoText: String,
    modifier: Modifier = Modifier
) {
    CustomTheme {
        CommonText(
            TextAttributes(
                text = logoText,
                textAlign = TextAlign.Center,
                textStyle = CustomTheme.typography.titleBold,
                textColor = CustomTheme.colors.logoColor,
                modifier = modifier.padding(bottom = 16.dp),
            )
        )
    }
}

@Composable
@Preview(
    name = "Light Mode",
    showBackground = true,
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
private fun PreviewAppLogo() {
    CustomTheme {
        AppLogo(
            logoText = stringResource(id = R.string.app_logo)
        )
    }
}