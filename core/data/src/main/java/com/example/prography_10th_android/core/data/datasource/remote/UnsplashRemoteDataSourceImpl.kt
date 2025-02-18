package com.example.prography_10th_android.core.data.datasource.remote

import com.example.prography_10th_android.core.network.UnsplashService
import com.example.prography_10th_android.core.network.model.UnsplashPhotoResponse
import javax.inject.Inject

class UnsplashRemoteDataSourceImpl @Inject constructor(
    private val unsplashService: UnsplashService
): UnsplashRemoteDataSource {
    override suspend fun getPhotos(page: Int, pageSize: Int): List<UnsplashPhotoResponse> {
        return unsplashService.getPhotos(page = page, pageSize = pageSize)
    }
}
