package com.example.prography_10th_android.core.domain.usecase

import com.example.prography_10th_android.core.domain.repository.UnsplashRepository
import com.example.prography_10th_android.core.model.UnsplashPhotoDetail
import javax.inject.Inject

class SaveBookmarkUseCase @Inject constructor(
    private val unsplashRepository: UnsplashRepository
) {
    suspend operator fun invoke(unsplashPhotoDetail: UnsplashPhotoDetail) =
        unsplashRepository.insertBookmark(unsplashPhotoDetail = unsplashPhotoDetail)
}
