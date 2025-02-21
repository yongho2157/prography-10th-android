package com.example.prography_10th_android.core.domain.usecase

import com.example.prography_10th_android.core.domain.repository.UnsplashRepository
import javax.inject.Inject

class DeleteBookmarkUseCase @Inject constructor(
    private val unsplashRepository: UnsplashRepository
) {
    suspend operator fun invoke(id: String) =
        unsplashRepository.deleteBookmark(id = id)
}
