package com.example.prography_10th_android.core.data.mapper

import com.example.prography_10th_android.core.database.entity.BookmarkEntity
import com.example.prography_10th_android.core.model.UnsplashPhotoDetail

object BookmarkMapper {
    fun BookmarkEntity.toModel(): UnsplashPhotoDetail =
        UnsplashPhotoDetail(
            id = id,
            username = username,
            title = title,
            url = url,
            description = description,
            tags = tags
        )

    fun UnsplashPhotoDetail.toEntity(): BookmarkEntity {
        return BookmarkEntity(
            id = id,
            username = username,
            title = title,
            url = url,
            description = description,
            tags = tags
        )
    }
}
