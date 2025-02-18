package com.example.prography_10th_android.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopicSubmission(
    @SerialName("status") val status: String,
    @SerialName("approved_on") val approvedOn: String
)
