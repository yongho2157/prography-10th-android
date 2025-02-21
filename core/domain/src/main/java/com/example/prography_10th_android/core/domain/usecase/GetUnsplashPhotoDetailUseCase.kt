package com.example.prography_10th_android.core.domain.usecase

import com.example.prography_10th_android.core.domain.repository.UnsplashRepository
import com.example.prography_10th_android.core.model.UnsplashPhotoDetail
import com.example.prography_10th_android.core.common.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUnsplashPhotoDetailUseCase @Inject constructor(
    private val unsplashRepository: UnsplashRepository
) {
    operator fun invoke(id: String): Flow<Result<UnsplashPhotoDetail>> = flow {
        try {
            emit(Result.Loading)
            emit(unsplashRepository.getPhotoDetail(id = id))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
}
