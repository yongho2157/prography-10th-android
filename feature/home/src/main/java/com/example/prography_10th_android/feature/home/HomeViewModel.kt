package com.example.prography_10th_android.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.prography_10th_android.core.domain.usecase.GetBookmarkedUnsplashPhotosDetailUseCase
import com.example.prography_10th_android.core.domain.usecase.GetUnsplashPhotosUseCase
import com.example.prography_10th_android.core.model.UnsplashPhoto
import com.example.prography_10th_android.core.model.UnsplashPhotoDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getUnsplashPhotosUseCase: GetUnsplashPhotosUseCase,
    getBookmarkedUnsplashPhotosDetailUseCase: GetBookmarkedUnsplashPhotosDetailUseCase
) : ViewModel() {
    val photos: Flow<PagingData<UnsplashPhoto>> = getUnsplashPhotosUseCase()
    val bookmarkPhotos: StateFlow<List<UnsplashPhotoDetail>> =
        getBookmarkedUnsplashPhotosDetailUseCase()
            .map { it ?: emptyList() }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )
}


