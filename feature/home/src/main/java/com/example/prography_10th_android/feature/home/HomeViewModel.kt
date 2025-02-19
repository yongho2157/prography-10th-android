package com.example.prography_10th_android.feature.home

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.prography_10th_android.core.domain.usecase.GetUnsplashPhotosUseCase
import com.example.prography_10th_android.core.model.UnsplashPhoto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    getUnsplashPhotosUseCase: GetUnsplashPhotosUseCase
) : ViewModel() {

    val photos: Flow<PagingData<UnsplashPhoto>> = getUnsplashPhotosUseCase()
}


