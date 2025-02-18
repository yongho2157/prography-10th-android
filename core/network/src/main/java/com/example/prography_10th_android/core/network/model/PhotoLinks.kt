package com.example.prography_10th_android.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoLinks(
    @SerialName("self") val self: String,
    @SerialName("html") val html: String,
    @SerialName("download") val download: String,
    @SerialName("download_location") val downloadLocation: String
)
