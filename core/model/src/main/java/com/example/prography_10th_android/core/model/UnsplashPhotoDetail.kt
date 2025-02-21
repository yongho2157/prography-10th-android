package com.example.prography_10th_android.core.model

import kotlinx.serialization.Serializable

@Serializable
data class UnsplashPhotoDetail(
    val id: String,
    val username: String,
    val title: String,
    val url: String,
    val description: String,
    val tags: List<String>
)
