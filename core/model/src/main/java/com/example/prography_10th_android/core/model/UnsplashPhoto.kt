package com.example.prography_10th_android.core.model

import kotlinx.serialization.Serializable

@Serializable
data class UnsplashPhoto(
    val id: String,
    val title: String,
    val url: String
)
