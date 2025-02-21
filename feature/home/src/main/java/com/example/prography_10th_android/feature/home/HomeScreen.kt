package com.example.prography_10th_android.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.prography_10th_android.core.designsystem.component.ImageShimmer
import com.example.prography_10th_android.core.model.UnsplashPhoto
import com.example.prography_10th_android.core.model.UnsplashPhotoDetail
import com.example.prography_10th_android.feature.home.component.BookmarkPhoto
import com.example.prography_10th_android.feature.home.component.RecentUnsplashPhoto
import kotlinx.coroutines.delay


@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
    onPhotoClick: (String) -> Unit
) {
    val photos = viewModel.photos.collectAsLazyPagingItems()
    val bookmarkPhotos by viewModel.bookmarkPhotos.collectAsStateWithLifecycle()
    HomeScreen(
        bookmarkPhotos = bookmarkPhotos,
        photos = photos,
        onPhotoClick = onPhotoClick
    )
}

@Composable
fun HomeScreen(
    bookmarkPhotos: List<UnsplashPhotoDetail>,
    photos: LazyPagingItems<UnsplashPhoto>,
    onPhotoClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        if (bookmarkPhotos.isNotEmpty()) {
            Text(
                text = stringResource(id = R.string.bookmark_photos),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                contentPadding = PaddingValues(horizontal = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(bookmarkPhotos.size) { index ->
                    val bookmarkPhoto = bookmarkPhotos[index]
                    BookmarkPhoto(
                        bookmarkPhoto = bookmarkPhoto,
                        onPhotoClick = onPhotoClick
                    )
                }
            }
        }

        Text(
            text = stringResource(id = R.string.recent_photos),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
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
                    PhotoItemWithShimmer {
                        RecentUnsplashPhoto(
                            unsplashPhoto = photo,
                            onPhotoClick = onPhotoClick
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun PhotoItemWithShimmer(
    content: @Composable () -> Unit
) {
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(1000)
        isLoading = false
    }

    ImageShimmer(isLoading = isLoading, contentAfterLoading = {
        content()
    })
}
