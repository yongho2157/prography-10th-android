package com.example.prography_10th_android.feature.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.example.prography_10th_android.core.designsystem.component.FullScreenLoading
import com.example.prography_10th_android.core.designsystem.component.UnSplashPhotoCard
import com.example.prography_10th_android.core.model.UnsplashPhotoDetail
import com.example.prography_10th_android.feature.detail.component.DetailTopBar
import com.example.prography_10th_android.feature.detail.component.PhotoDetailInfo
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun DetailRoute(
    viewModel: DetailViewModel = hiltViewModel(),
    id: String,
    onClickClose: () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    DisposableEffect(Unit) {
        systemUiController.setStatusBarColor(
            color = Color.Black.copy(alpha = 0.8f),
            darkIcons = false
        )
        onDispose {
            systemUiController.setStatusBarColor(
                color = Color.Black,
                darkIcons = true
            )
        }
    }

    val detailUiState by viewModel.detailUiState.collectAsStateWithLifecycle()

    LaunchedEffect(id) {
        viewModel.fetchDetailPhoto(id)
    }

    DetailScreen(
        detailUiState = detailUiState,
        onClickClose = onClickClose,
        onClickDownload = {},
        onClickBookmark = {},
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets(0, 0, 0, 0))
            .background(
                color = Color.Black.copy(alpha = 0.8f),
            )
    )
}

@Composable
fun DetailScreen(
    detailUiState: DetailUiState,
    onClickClose: () -> Unit,
    onClickDownload: () -> Unit,
    onClickBookmark: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (detailUiState) {
        is DetailUiState.HasDetailPhoto -> {
            DetailPhotoContent(
                unsplashPhotoDetail = detailUiState.detailPhoto,
                onClickClose = onClickClose,
                onClickDownload = onClickDownload,
                onClickBookmark = onClickBookmark,
                modifier = modifier
            )
        }

        is DetailUiState.Loading -> {
           FullScreenLoading()
        }

        is DetailUiState.Error -> {

        }
    }
}

@Composable
private fun DetailPhotoContent(
    unsplashPhotoDetail: UnsplashPhotoDetail,
    onClickClose: () -> Unit,
    onClickDownload: () -> Unit,
    onClickBookmark: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = { onClickClose() },
        properties = DialogProperties(
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false
        )
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            DetailTopBar(
                username = unsplashPhotoDetail.username,
                onClickClose = onClickClose,
                onClickDownload = onClickDownload,
                onClickBookmark = onClickBookmark,
            )

            UnSplashPhotoCard(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
            ) {
                AsyncImage(
                    model = unsplashPhotoDetail.url,
                    contentDescription = unsplashPhotoDetail.description,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            PhotoDetailInfo(
                title = unsplashPhotoDetail.title,
                description = unsplashPhotoDetail.description,
                tags = unsplashPhotoDetail.tags,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}



@Preview
@Composable
private fun DetailScreenPreview() {
//    DetailScreen()
}

