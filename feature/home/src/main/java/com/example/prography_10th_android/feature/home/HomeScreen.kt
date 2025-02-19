package com.example.prography_10th_android.feature.home

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.prography_10th_android.core.designsystem.component.ImageShimmer
import com.example.prography_10th_android.core.designsystem.component.UnSplashTopBar
import com.example.prography_10th_android.core.model.UnsplashPhoto
import com.example.prography_10th_android.feature.home.component.RecentUnsplashPhoto
import kotlinx.coroutines.delay


@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    Log.d("결과", "HomeRoute: ")
    val photos = viewModel.photos.collectAsLazyPagingItems()
    Log.d("결과", "HomeRoute: $photos")
    LaunchedEffect(key1 = photos.loadState) {
        Log.d("결과", "Refresh LoadState: ${photos.loadState.refresh}")
        Log.d("결과", "Append LoadState: ${photos.loadState.append}")
        Log.d("결과", "Prepend LoadState: ${photos.loadState.prepend}")
    }
    HomeScreen(
        photos = photos
    )
}

@Composable
fun HomeScreen(
    photos: LazyPagingItems<UnsplashPhoto>,
) {
    Scaffold(
        topBar = { UnSplashTopBar() }
    ) { paddingValues ->
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(photos.itemCount) { index ->
                photos[index]?.let { photo ->
                    var isLoading by remember { mutableStateOf(true) }

                    LaunchedEffect(photo) {
                        delay(2000)
                        isLoading = false
                    }
                    ImageShimmer(
                        isLoading = isLoading,
                        contentAfterLoading = { RecentUnsplashPhoto(unsplashPhoto = photo) })
                }
            }
        }
    }

}
