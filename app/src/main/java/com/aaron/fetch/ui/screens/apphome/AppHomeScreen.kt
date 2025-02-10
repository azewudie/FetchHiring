package com.aaron.fetch.ui.screens.apphome

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.aaron.fetch.R
import com.aaron.fetch.ui.theme.CustomTheme
import com.aaron.fetch.ui.common.compose.CommonImageHeaderDescriptionCard
import com.aaron.fetch.ui.common.compose.CommonText
import com.aaron.fetch.ui.common.composeattributes.TextAttributes
import com.aaron.fetch.ui.common.screenstate.UIState
import kotlinx.coroutines.flow.flow

@Composable
fun AppHomeScreen(
    progressState: State<UIState>,
    screeState: State<AppHomeScreenUIStates>,
    onEvent: (AppHomeScreenUIEvents) -> Unit
) {
    LaunchedEffect(Unit) {
        onEvent.invoke(AppHomeScreenUIEvents.GetInitialData)
    }
    CustomTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(CustomTheme.colors.backGrounds),
            contentAlignment = Alignment.Center,

            ) {

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(
                        CustomTheme.spaces.dp16,
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CommonText(
                    TextAttributes(
                        text = screeState.value.appHomeHeader,
                        textColor = CustomTheme.colors.text0,
                        textStyle = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                    )
                )
                LazyRow {
                    screeState.value.appHomeGroupedAndSortedList.forEach { (listId, _) ->
                        item {
                            CommonText(
                                TextAttributes(
                                    text = "GROUP:$listId",
                                    textColor = if (listId == screeState.value.appHomeGroupedIndex)
                                        CustomTheme.colors.logoColor
                                    else CustomTheme.colors.text0,
                                    textStyle = MaterialTheme.typography.bodyLarge,
                                    textAlign = TextAlign.Center,
                                    textDecoration = TextDecoration.Underline,
                                    modifier = Modifier
                                        .padding(
                                            vertical = CustomTheme.spaces.dp16,
                                            horizontal = CustomTheme.spaces.dp16
                                        )
                                        .clickable {
                                            onEvent.invoke(
                                                AppHomeScreenUIEvents.OnClickedGroup(
                                                    listId
                                                )
                                            )
                                        }
                                )
                            )
                        }
                    }
                }

                screeState.value.appHomeGroupedAndSortedList[screeState.value.appHomeGroupedIndex]?.forEach { hiringResponseItem ->
                    hiringResponseItem.id?.let { id ->
                        hiringResponseItem.name?.let { name ->
                            hiringResponseItem.listId?.let { listId ->
                                CommonImageHeaderDescriptionCard(
                                    name,
                                    id,
                                    listId
                                )
                            }
                        }
                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(CustomTheme.spaces.dp16)
                    )
                }

            }
            if (progressState.value == UIState.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

        }
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
private fun PreviewAppHomeScreen() {
    CustomTheme {
        AppHomeScreen(
            screeState = flow<AppHomeScreenUIStates> {}.collectAsState(
                initial = AppHomeScreenUIStates(
                    appHomeHeader = stringResource(R.string.app_home_header),
                )
            ),
            onEvent = {},
            progressState = flow<UIState> {}.collectAsState(initial = UIState.Success),
        )
    }
}