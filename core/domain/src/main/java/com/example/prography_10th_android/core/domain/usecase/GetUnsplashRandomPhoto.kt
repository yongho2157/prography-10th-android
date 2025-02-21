package com.example.prography_10th_android.core.domain.usecase

import com.example.prography_10th_android.core.common.Result
import com.example.prography_10th_android.core.domain.repository.UnsplashRepository
import com.example.prography_10th_android.core.model.UnsplashPhoto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUnsplashRandomPhotoUseCase @Inject constructor(
    private val unsplashRepository: UnsplashRepository
) {
    operator fun invoke(): Flow<Result<UnsplashPhoto>> = flow {
        try {
            emit(Result.Loading)
            emit(unsplashRepository.getRandomPhoto())
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
}
