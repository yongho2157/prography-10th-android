package com.example.prography_10th_android.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileImage(
    @SerialName("small") val small: String,
    @SerialName("medium") val medium: String,
    @SerialName("large") val large: String
)
