package com.example.prography_10th_android.feature.detail.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.prography_10th_android.core.model.UnsplashPhotoDetail

@Composable
fun DetailPhoto(
    photoDetail: UnsplashPhotoDetail,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(10.dp))
                .align(Alignment.Center)
        ) {
            AsyncImage(
                model = photoDetail.url,
                contentDescription = photoDetail.description,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}


@Preview
@Composable
private fun DetailPhotoPreview() {
    val photoDetail = UnsplashPhotoDetail(
        id = "id",
        title = "title",
        url = "https://images.unsplash.com/photo-1733506260573-2ddbf1db9b1a?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3MDkyMzJ8MHwxfGFsbHx8fHx8fHx8fDE3NDAwNjc1NzF8&ixlib=rb-4.0.3&q=80&w=1080",
        username = "username",
        description = "description",
        tags = listOf("test", "test", "test")
    )
    DetailPhoto(
        photoDetail = photoDetail
    )
}
