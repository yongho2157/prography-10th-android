package com.example.prography_10th_android.core.domain.usecase

import androidx.paging.PagingData
import com.example.prography_10th_android.core.domain.repository.UnsplashRepository
import com.example.prography_10th_android.core.model.UnsplashPhoto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUnsplashPhotosUseCase @Inject constructor(
    private val unsplashRepository: UnsplashRepository
) {
    suspend operator fun invoke(page: Int, pageSize: Int): Flow<PagingData<UnsplashPhoto>> =
        unsplashRepository.getPhotoPagingFlow(page = page, pageSize = pageSize)
}
