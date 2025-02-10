package com.aaron.fetch.ui.common.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.aaron.fetch.R
import com.aaron.fetch.ui.common.composeattributes.TextAttributes
import com.aaron.fetch.ui.theme.CustomTheme
import com.aaron.fetch.utilities.constants.AppConstants

@Composable
fun CommonImageHeaderDescriptionCard(
    name: String = AppConstants.EMPTY_STRING,
    id: Int = Int.MIN_VALUE,
    listId: Int = Int.MIN_VALUE,
    cardImage: String = AppConstants.EMPTY_STRING,
) {
    CustomTheme {
        Card(
            modifier =
            Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(CustomTheme.spaces.dp8),
            colors =
            CardDefaults.cardColors(
                containerColor = CustomTheme.colors.cardDefault,
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = CustomTheme.spaces.dp10),
        ) {
            Row(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .height(intrinsicSize = IntrinsicSize.Max),
            ) {
                ImageViewLoader(
                    model = cardImage,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(.4f)
                        .clip(shape = RoundedCornerShape(CustomTheme.spaces.dp8)),
                    imageDescription = stringResource(id = R.string.app_home_header),
                    placeHolderImage = painterResource(id = R.drawable.profile),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .weight(.6f)
                        .padding(
                            horizontal = CustomTheme.spaces.dp16,
                            vertical = CustomTheme.spaces.dp12
                        ),
                ) {
                    ResponsiveText(
                        text = name,
                        color = CustomTheme.colors.text0,
                        textStyle = CustomTheme.typography.title0Regular,
                        modifier =
                        Modifier
                            .fillMaxWidth(),
                        maxLines = 4,
                        textAlign = TextAlign.Start,
                        targetTextSizeHeight = 13.sp
                    )
                    CommonText(
                        TextAttributes(
                            modifier =
                            Modifier
                                .padding(bottom = CustomTheme.spaces.dp8)
                                .fillMaxWidth(),
                            text = id.toString(),
                            textStyle = MaterialTheme.typography.bodyLarge,
                            textColor = CustomTheme.colors.text0,
                        )
                    )
                    CommonText(
                        TextAttributes(
                            modifier =
                            Modifier
                                .padding(bottom = CustomTheme.spaces.dp8)
                                .fillMaxWidth(),
                            text = listId.toString(),
                            textStyle = MaterialTheme.typography.bodyLarge,
                            textColor = CustomTheme.colors.text0,
                        )
                    )
                }
            }
        }
    }
}

@Composable
@Preview(
    name = "Light Mode",
    showBackground = true
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
private fun PreviewCommonImageHeaderDescriptionCard() {
    CustomTheme {
        CommonImageHeaderDescriptionCard(
            name = stringResource(id = R.string.app_logo),
            id = 1,
            listId = 3
        )
    }
}
