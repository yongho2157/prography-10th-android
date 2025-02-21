package com.example.prography_10th_android.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.prography_10th_android.core.common.Result
import com.example.prography_10th_android.core.data.datasource.local.UnsplashLocalDataSourceImpl
import com.example.prography_10th_android.core.data.datasource.remote.UnsplashRemoteDataSourceImpl
import com.example.prography_10th_android.core.data.mapper.BookmarkMapper.toEntity
import com.example.prography_10th_android.core.data.mapper.BookmarkMapper.toModel
import com.example.prography_10th_android.core.data.paging.UnsplashPagingSource
import com.example.prography_10th_android.core.domain.repository.UnsplashRepository
import com.example.prography_10th_android.core.model.UnsplashPhoto
import com.example.prography_10th_android.core.model.UnsplashPhotoDetail
import com.example.prography_10th_android.core.network.model.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UnsplashRepositoryImpl @Inject constructor(
    private val unsplashLocalDataSource: UnsplashLocalDataSourceImpl,
    private val unsplashRemoteDataSource: UnsplashRemoteDataSourceImpl
) : UnsplashRepository {
    override fun getPhotosPagingFlow(): Flow<PagingData<UnsplashPhoto>> {
        return Pager(config = PagingConfig(
            pageSize = 10, enablePlaceholders = false
        ), pagingSourceFactory = { UnsplashPagingSource(unsplashRemoteDataSource) }).flow
    }

    override suspend fun getRandomPhoto(): Result<UnsplashPhoto> {
        try {
            val result = unsplashRemoteDataSource.getRandomPhoto().toModel()
            return Result.Success(result)
        } catch (e: Exception) {
            return Result.Error(e)
        }
    }

    override suspend fun getPhotoDetail(id: String): Result<UnsplashPhotoDetail> {
        try {
            val result = unsplashRemoteDataSource.getPhotoDetail(id).toModel()
            return Result.Success(result)
        } catch (e: Exception) {
            return Result.Error(e)
        }
    }

    override fun getBookmarks(): Flow<List<UnsplashPhotoDetail>> {
        return unsplashLocalDataSource.getBookmarks().map {
            it.map { bookmarkEntity ->
                bookmarkEntity.toModel()
            }
        }
    }



    override fun getBookmark(id: String): Flow<UnsplashPhotoDetail?> {
        return unsplashLocalDataSource.getBookmark(id).map { bookmarkEntity ->
            bookmarkEntity?.toModel()
        }
    }

    override suspend fun insertBookmark(unsplashPhotoDetail: UnsplashPhotoDetail) {
        return unsplashLocalDataSource.insertBookmark(unsplashPhotoDetail.toEntity())
    }

    override suspend fun deleteBookmark(id: String) {
        return unsplashLocalDataSource.deleteBookmark(id)
    }
}
