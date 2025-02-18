package com.example.prography_10th_android.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("id") val id: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("username") val username: String,
    @SerialName("name") val name: String,
    @SerialName("first_name") val firstName: String,
    @SerialName("last_name") val lastName: String?,
    @SerialName("twitter_username") val twitterUsername: String?,
    @SerialName("portfolio_url") val portfolioUrl: String?,
    @SerialName("bio") val bio: String?,
    @SerialName("location") val location: String?,
    @SerialName("links") val links: UserLinks,
    @SerialName("profile_image") val profileImage: ProfileImage,
    @SerialName("instagram_username") val instagramUsername: String?,
    @SerialName("total_collections") val totalCollections: Int,
    @SerialName("total_likes") val totalLikes: Int,
    @SerialName("total_photos") val totalPhotos: Int,
    @SerialName("total_promoted_photos") val totalPromotedPhotos: Int,
    @SerialName("total_illustrations") val totalIllustrations: Int,
    @SerialName("total_promoted_illustrations") val totalPromotedIllustrations: Int,
    @SerialName("accepted_tos") val acceptedTos: Boolean,
    @SerialName("for_hire") val forHire: Boolean,
    @SerialName("social") val social: Social
)
