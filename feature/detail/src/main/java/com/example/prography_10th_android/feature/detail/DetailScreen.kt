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
    id: String,
    onClickClose: () -> Unit,
    viewModel: DetailViewModel = hiltViewModel(),
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
    val isBookmarked by viewModel.isBookmarked.collectAsStateWithLifecycle()

    LaunchedEffect(id) {
        viewModel.fetchDetailPhoto(id)
    }

    DetailScreen(
        detailUiState = detailUiState,
        isBookmarked = isBookmarked,
        onClickClose = onClickClose,
        onClickDownload = {},
        onClickBookmark = {
            if (detailUiState is DetailUiState.HasDetailPhoto) {
                viewModel.toggleBookmark((detailUiState as DetailUiState.HasDetailPhoto).detailPhoto)
            }
        },
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
    isBookmarked: Boolean,
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
                isBookmarked = isBookmarked,
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
    isBookmarked: Boolean,
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
                isBookmarked = isBookmarked,
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
    val photoDetail = UnsplashPhotoDetail(
        id = "id",
        title = "title",
        url = "https://images.unsplash.com/photo-1733506260573-2ddbf1db9b1a?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3MDkyMzJ8MHwxfGFsbHx8fHx8fHx8fDE3NDAwNjc1NzF8&ixlib=rb-4.0.3&q=80&w=1080",
        username = "username",
        description = "description",
        tags = listOf("test", "test", "test")
    )
    DetailPhotoContent(
        unsplashPhotoDetail = photoDetail,
        onClickClose = {},
        onClickDownload = {},
        onClickBookmark = {},
        isBookmarked = false
    )
}

