package com.example.prography_10th_android.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.prography_10th_android.core.data.paging.UnsplashPagingSource
import com.example.prography_10th_android.core.data.datasource.remote.UnsplashRemoteDataSourceImpl
import com.example.prography_10th_android.core.domain.repository.UnsplashRepository
import com.example.prography_10th_android.core.model.UnsplashPhoto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UnsplashRepositoryImpl @Inject constructor(
    private val unsplashRemoteDataSource: UnsplashRemoteDataSourceImpl
): UnsplashRepository {
    override suspend fun getPhotosPagingFlow(): Flow<PagingData<UnsplashPhoto>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UnsplashPagingSource(unsplashRemoteDataSource) }
        ).flow
    }
}
