package com.example.prography_10th_android.core.network.model

import com.example.prography_10th_android.core.model.UnsplashPhotoDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UnsplashPhotoDetailResponse(
    val id: String,
    val description: String? = null,
    @SerialName("alt_description")
    val altDescription: String? = null,
    val urls: PhotoUrls,
    val tags: List<Tag?> = emptyList(),
    val user: User
)

fun UnsplashPhotoDetailResponse.toModel(): UnsplashPhotoDetail =
    UnsplashPhotoDetail(
        id = id,
        username = user.username,
        title = altDescription ?: "",
        description = description ?: "",
        url = urls.regular,
        tags = tags.map { it?.title ?: "" }
    )


