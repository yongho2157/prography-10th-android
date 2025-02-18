package com.example.prography_10th_android.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Social(
    @SerialName("instagram_username") val instagramUsername: String?,
    @SerialName("portfolio_url") val portfolioUrl: String?,
    @SerialName("twitter_username") val twitterUsername: String?,
    @SerialName("paypal_email") val paypalEmail: String?
)
