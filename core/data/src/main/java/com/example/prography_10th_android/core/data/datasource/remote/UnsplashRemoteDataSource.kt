package com.example.prography_10th_android.core.data.datasource.remote

import com.example.prography_10th_android.core.network.model.UnsplashPhotoResponse

interface UnsplashRemoteDataSource {
    suspend fun getPhotos(page: Int, pageSize: Int): List<UnsplashPhotoResponse>
}
