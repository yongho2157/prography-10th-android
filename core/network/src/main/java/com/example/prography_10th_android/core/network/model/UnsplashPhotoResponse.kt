package com.example.prography_10th_android.core.network.model

import com.example.prography_10th_android.core.model.UnsplashPhoto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UnsplashPhotoResponse(
    @SerialName("id") val id: String,
    @SerialName("slug") val slug: String,
    @SerialName("alternative_slugs") val alternativeSlugs: AlternativeSlugs,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("promoted_at") val promotedAt: String?,
    @SerialName("width") val width: Int,
    @SerialName("height") val height: Int,
    @SerialName("color") val color: String,
    @SerialName("blur_hash") val blurHash: String,
    @SerialName("description") val description: String?,
    @SerialName("alt_description") val altDescription: String,
    @SerialName("breadcrumbs") val breadcrumbs: List<String>,
    @SerialName("urls") val urls: PhotoUrls,
    @SerialName("links") val links: PhotoLinks,
    @SerialName("likes") val likes: Int,
    @SerialName("liked_by_user") val likedByUser: Boolean,
    @SerialName("current_user_collections") val currentUserCollections: List<String>,
    @SerialName("sponsorship") val sponsorship: PhotoSponsorship?,
    @SerialName("topic_submissions") val topicSubmissions: Map<String, TopicSubmission?>,
    @SerialName("asset_type") val assetType: String,
    @SerialName("user") val user: User
)

fun UnsplashPhotoResponse.toModel(): UnsplashPhoto =
    UnsplashPhoto(
        id = id,
        title = altDescription,
        url = urls.thumb
    )


