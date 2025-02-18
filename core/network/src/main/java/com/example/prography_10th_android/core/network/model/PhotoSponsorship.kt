package com.example.prography_10th_android.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoSponsorship(
    @SerialName("impression_urls") val impressionUrls: List<String>,
    @SerialName("tagline") val tagline: String,
    @SerialName("tagline_url") val taglineUrl: String,
    @SerialName("sponsor") val sponsor: User
)
