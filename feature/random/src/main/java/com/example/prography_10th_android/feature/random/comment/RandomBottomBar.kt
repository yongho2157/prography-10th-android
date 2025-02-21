package com.example.prography_10th_android.feature.random.comment

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prography_10th_android.core.designsystem.theme.Gray60
import com.example.prography_10th_android.feature.random.R

@Composable
fun RandomBottomBar(
    id: String,
    onClickClose: () -> Unit,
    onClickBookmark: () -> Unit,
    onClickInfo: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onClickClose,
            modifier = Modifier
                .size(52.dp)
                .border(
                    width = 1.dp,
                    color = Gray60,
                    shape = CircleShape
                )
                .background(
                    shape = CircleShape,
                    color = Color.White
                )
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_close
                ),
                contentDescription = "",
                tint = Gray60
            )
        }

        IconButton(
            onClick = onClickBookmark,
            modifier = Modifier
                .size(72.dp)
                .background(
                    shape = CircleShape,
                    color = Color(0xFFD81D45)
                )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_bookmark),
                contentDescription = "Bookmark",
                tint = Color.White
            )
        }

        IconButton(
            onClick = { onClickInfo(id) },
            modifier = Modifier
                .size(52.dp)
                .border(
                    width = 1.dp,
                    color = Gray60,
                    shape = CircleShape
                )
                .background(
                    shape = CircleShape,
                    color = Color.White
                )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_info),
                contentDescription = "Bookmark",
                tint = Gray60
            )
        }
    }
}

@Preview
@Composable
private fun RandomBottomBarPreview() {
    RandomBottomBar(id = "", {}, {}, {})
}

