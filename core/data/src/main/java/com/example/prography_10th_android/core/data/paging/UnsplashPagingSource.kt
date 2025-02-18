package com.example.prography_10th_android.core.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.prography_10th_android.core.data.datasource.remote.UnsplashRemoteDataSource
import com.example.prography_10th_android.core.model.UnsplashPhoto
import com.example.prography_10th_android.core.network.model.toModel
import javax.inject.Inject

class UnsplashPagingSource @Inject constructor(
    private val remoteDataSource: UnsplashRemoteDataSource
): PagingSource<Int, UnsplashPhoto>() {

    override fun getRefreshKey(state: PagingState<Int, UnsplashPhoto>): Int? =
        state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> =
        try {
            val page = params.key ?: STARTING_PAGE
            val photos = remoteDataSource.getPhotos(page = page, pageSize = params.loadSize).map { it.toModel() }

            LoadResult.Page(
                data = photos,
                prevKey = if (page == STARTING_PAGE) null else page - 1,
                nextKey = if (photos.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    companion object {
        private const val STARTING_PAGE = 1
    }
}
