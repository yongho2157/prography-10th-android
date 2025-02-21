package com.example.prography_10th_android.feature.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prography_10th_android.feature.datail.R

@Composable
fun DetailTopBar(
    username: String,
    onClickClose: () -> Unit,
    onClickDownload: () -> Unit,
    onClickBookmark: () -> Unit,
    isBookmarked: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                modifier = Modifier
                    .size(36.dp)
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    ),
                onClick = onClickClose
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = stringResource(id = R.string.close_button_description)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = username,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row {
            IconButton(
                onClick = onClickDownload, modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = Color.Transparent
                    )
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_download
                    ),
                    contentDescription = stringResource(id = R.string.download_button_description),
                    tint = Color.White
                )
            }
            IconButton(
                onClick = onClickBookmark,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(40.dp)
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_bookmark
                    ),
                    contentDescription = stringResource(id = R.string.bookmark_button_description),
                    tint = if (isBookmarked) Color.White.copy(alpha = 1f)
                    else Color.White.copy(alpha = 0.3f)
                )
            }
        }
    }
}

@Preview
@Composable
private fun DetailTopBarPreview() {
    DetailTopBar(
        username = "UserName",
        onClickClose = {},
        onClickDownload = {},
        onClickBookmark = {},
        isBookmarked = false
    )
}
