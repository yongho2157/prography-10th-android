package com.example.prography_10th_android.core.network

import retrofit2.http.GET
import com.example.prography_10th_android.core.network.model.UnsplashPhotoResponse
import retrofit2.http.Query

interface UnsplashService {

    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): List<UnsplashPhotoResponse>

}
