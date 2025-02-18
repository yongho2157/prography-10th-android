package com.example.prography_10th_android.core.domain.repository

import androidx.paging.PagingData
import com.example.prography_10th_android.core.model.UnsplashPhoto
import kotlinx.coroutines.flow.Flow

interface UnsplashRepository {
    suspend fun getPhotosPagingFlow(): Flow<PagingData<UnsplashPhoto>>
}
