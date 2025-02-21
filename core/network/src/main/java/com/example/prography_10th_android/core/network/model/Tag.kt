package com.example.prography_10th_android.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    val type: String,
    val title: String
)
