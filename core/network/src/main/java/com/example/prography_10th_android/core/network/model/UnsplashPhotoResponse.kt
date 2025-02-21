package com.example.prography_10th_android.core.network.model

import com.example.prography_10th_android.core.model.UnsplashPhoto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UnsplashPhotoResponse(
    val id: String,
    @SerialName("alt_description")
    val altDescription: String? = null,
    val urls: PhotoUrls,
)

fun UnsplashPhotoResponse.toModel(): UnsplashPhoto =
    UnsplashPhoto(
        id = id,
        title = altDescription ?: "",
        url = urls.thumb
    )


