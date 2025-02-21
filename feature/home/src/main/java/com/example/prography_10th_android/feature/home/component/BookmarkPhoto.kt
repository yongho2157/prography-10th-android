package com.example.prography_10th_android.feature.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.prography_10th_android.core.designsystem.component.UnSplashPhotoCard
import com.example.prography_10th_android.core.model.UnsplashPhotoDetail

@Composable
fun BookmarkPhoto(
    bookmarkPhoto: UnsplashPhotoDetail,
    onPhotoClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    UnSplashPhotoCard(
        modifier = modifier
            .height(128.dp)
            .clickable { onPhotoClick(bookmarkPhoto.id) },
    ) {
        AsyncImage(
            model = bookmarkPhoto.url,
            contentDescription = bookmarkPhoto.description,
            contentScale = ContentScale.Crop,
            modifier = Modifier
        )
    }
}
