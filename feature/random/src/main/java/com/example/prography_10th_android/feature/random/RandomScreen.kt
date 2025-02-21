package com.example.prography_10th_android.feature.random

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.example.prography_10th_android.core.designsystem.component.FullScreenLoading
import com.example.prography_10th_android.core.designsystem.component.UnSplashPhotoCard
import com.example.prography_10th_android.core.designsystem.theme.Gray30
import com.example.prography_10th_android.core.model.UnsplashPhoto
import com.example.prography_10th_android.feature.random.comment.RandomBottomBar

@Composable
fun RandomRoute(
    onClickInfo: (String) -> Unit,
    viewModel: RandomViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.fetchRandomPhoto()
    }

    val randomUiState by viewModel.randomUiState.collectAsStateWithLifecycle()

    RandomScreen(
        randomUiState = randomUiState,
        onClickInfo = onClickInfo,
    )
}

@Composable
fun RandomScreen(
    randomUiState: RandomUiState,
    onClickInfo: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    when (randomUiState) {
        is RandomUiState.HasRandomPhoto -> {
            RandomCard(
                unsplashPhoto = randomUiState.photo,
                onClickClose = { },
                onClickBookmark = {},
                onClickInfo = onClickInfo,
                modifier = modifier
            )
        }

        is RandomUiState.Loading -> {
            FullScreenLoading()
        }

        is RandomUiState.Error -> {

        }
    }
}


@Composable
fun RandomCard(
    unsplashPhoto: UnsplashPhoto,
    onClickClose: () -> Unit,
    onClickBookmark: () -> Unit,
    onClickInfo: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .border(width = 1.dp, color = Gray30)
            .padding(start = 24.dp, top = 28.dp, bottom = 44.dp, end = 24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
        ) {
            UnSplashPhotoCard(
                modifier = Modifier
                    .padding(
                        start = 12.dp,
                        top = 12.dp,
                        end = 12.dp
                    )
                    .weight(3f)
            ) {
                AsyncImage(
                    model = unsplashPhoto.url,
                    contentDescription = unsplashPhoto.title,
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }

            RandomBottomBar(
                id = unsplashPhoto.id,
                onClickClose = onClickClose,
                onClickBookmark = onClickBookmark,
                onClickInfo = onClickInfo,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview
@Composable
private fun RandomCardPreview() {
    val unsplashPhoto = UnsplashPhoto(
        id = "id",
        title = "title",
        url = "https://images.unsplash.com/photo-1738332465678-be640ebb3a82?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3MDkyMzJ8MHwxfGFsbHwxNnx8fHx8fHx8MTczOTg3ODY3MHw&ixlib=rb-4.0.3&q=80&w=200"
    )
    RandomCard(
        unsplashPhoto = unsplashPhoto,
        onClickClose = {},
        onClickBookmark = {},
        onClickInfo = {}
    )
}
