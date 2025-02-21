package com.example.prography_10th_android.core.data.datasource.local

import com.example.prography_10th_android.core.database.dao.BookmarkDao
import com.example.prography_10th_android.core.database.entity.BookmarkEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UnsplashLocalDataSourceImpl @Inject constructor(
    private val bookmarkDao: BookmarkDao
) : UnsplashLocalDataSource {
    override fun getBookmarks(): Flow<List<BookmarkEntity>> =
        bookmarkDao.getBookmarks()

    override fun getBookmark(id: String): Flow<BookmarkEntity?> =
        bookmarkDao.getBookmark(id)

    override suspend fun insertBookmark(bookmarkEntity: BookmarkEntity) =
        bookmarkDao.insertBookmark(bookmarkEntity)

    override suspend fun deleteBookmark(id: String) =
        bookmarkDao.deleteBookmark(id)
}
