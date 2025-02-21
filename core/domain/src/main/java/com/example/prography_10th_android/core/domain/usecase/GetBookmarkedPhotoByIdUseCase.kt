package com.example.prography_10th_android.core.domain.usecase

import com.example.prography_10th_android.core.domain.repository.UnsplashRepository
import com.example.prography_10th_android.core.model.UnsplashPhotoDetail
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookmarkedPhotoByIdUseCase @Inject constructor(
    private val unsplashRepository: UnsplashRepository
) {
    operator fun invoke(id: String): Flow<UnsplashPhotoDetail?> =
        unsplashRepository.getBookmark(id = id)
}
