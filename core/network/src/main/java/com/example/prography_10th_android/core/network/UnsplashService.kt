package com.example.prography_10th_android.core.network

import com.example.prography_10th_android.core.network.model.UnsplashPhotoDetailResponse
import com.example.prography_10th_android.core.network.model.UnsplashPhotoResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UnsplashService {

    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): List<UnsplashPhotoResponse>

    @GET("photos/{id}")
    suspend fun getPhotoDetail(
        @Path(value = "id") id: String
    ): UnsplashPhotoDetailResponse

}
