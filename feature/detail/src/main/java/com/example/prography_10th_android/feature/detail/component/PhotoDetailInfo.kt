package com.example.prography_10th_android.feature.detail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PhotoDetailInfo(
    title: String,
    description: String,
    tags: List<String>,
    modifier: Modifier,
) {
    Column(
        modifier = modifier
            .padding(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 10.dp)
    ) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 20.sp,
        )
        Text(
            text = description,
            modifier = Modifier.padding(top = 4.dp),
            color = Color.White,
            fontSize = 15.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            modifier = Modifier.padding(top = 8.dp)
        ) {
            tags.forEach { tag ->
                Text(
                    text = "#$tag",
                    color = Color.White,
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
