package com.example.prography_10th_android.feature.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.prography_10th_android.core.designsystem.theme.Prography10thandroidTheme
import com.example.prography_10th_android.core.model.UnsplashPhoto

@Composable
internal fun RecentUnsplashPhoto(
    unsplashPhoto: UnsplashPhoto,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(10.dp))
    ) {
        AsyncImage(
            model = unsplashPhoto.url,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
        )

        PhotoTitle(
            title = unsplashPhoto.title,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(5.dp)
        )

    }
}

@Preview
@Composable
private fun RecentUnsplashPhotoPreview() {
    val unsplashPhoto = UnsplashPhoto(
        id = "id",
        title = "title",
        url = "https://images.unsplash.com/photo-1738332465678-be640ebb3a82?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3MDkyMzJ8MHwxfGFsbHwxNnx8fHx8fHx8MTczOTg3ODY3MHw&ixlib=rb-4.0.3&q=80&w=200"
    )
    Prography10thandroidTheme {
        RecentUnsplashPhoto(unsplashPhoto = unsplashPhoto)
    }
}
