package com.example.prography_10th_android.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.prography_10th_android.core.designsystem.component.ImageShimmer
import com.example.prography_10th_android.core.model.UnsplashPhoto
import com.example.prography_10th_android.feature.home.component.RecentUnsplashPhoto
import kotlinx.coroutines.delay


@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val photos = viewModel.photos.collectAsLazyPagingItems()
    HomeScreen(
        photos = photos
    )
}

@Composable
fun HomeScreen(
    photos: LazyPagingItems<UnsplashPhoto>,
) {
    RecentPhotosGrid(photos = photos)
}

@Composable
fun RecentPhotosGrid(
    photos: LazyPagingItems<UnsplashPhoto>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.recent_photos),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth().padding(13.dp)
        )

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 10.dp
        ) {
            items(photos.itemCount) { index ->
                photos[index]?.let { photo ->
                    PhotoItemWithShimmer(photo = photo)
                }
            }
        }
    }
}

@Composable
private fun PhotoItemWithShimmer(photo: UnsplashPhoto) {
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(photo) {
        delay(1000)
        isLoading = false
    }

    ImageShimmer(isLoading = isLoading, contentAfterLoading = {
        RecentUnsplashPhoto(unsplashPhoto = photo)
    })
}
