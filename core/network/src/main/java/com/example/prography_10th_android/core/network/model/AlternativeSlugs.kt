package com.example.prography_10th_android.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlternativeSlugs(
    @SerialName("en") val en: String,
    @SerialName("es") val es: String,
    @SerialName("ja") val ja: String,
    @SerialName("fr") val fr: String,
    @SerialName("it") val it: String,
    @SerialName("ko") val ko: String,
    @SerialName("de") val de: String,
    @SerialName("pt") val pt: String
)
