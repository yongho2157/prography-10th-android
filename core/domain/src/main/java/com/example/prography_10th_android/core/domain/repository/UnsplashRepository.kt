package com.example.prography_10th_android.core.domain.repository

import androidx.paging.PagingData
import com.example.prography_10th_android.core.common.Result
import com.example.prography_10th_android.core.model.UnsplashPhoto
import com.example.prography_10th_android.core.model.UnsplashPhotoDetail
import kotlinx.coroutines.flow.Flow

interface UnsplashRepository {
    fun getPhotosPagingFlow(): Flow<PagingData<UnsplashPhoto>>
    suspend fun getPhotoDetail(id: String): Result<UnsplashPhotoDetail>
}
