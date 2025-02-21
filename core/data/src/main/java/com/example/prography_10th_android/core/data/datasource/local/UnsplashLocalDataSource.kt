package com.example.prography_10th_android.core.data.datasource.local

import com.example.prography_10th_android.core.database.entity.BookmarkEntity
import kotlinx.coroutines.flow.Flow

interface UnsplashLocalDataSource {
    fun getBookmarks(): Flow<List<BookmarkEntity>>
    fun getBookmark(id: String): Flow<BookmarkEntity?>
    suspend fun insertBookmark(bookmarkEntity: BookmarkEntity)
    suspend fun deleteBookmark(id: String)
}
