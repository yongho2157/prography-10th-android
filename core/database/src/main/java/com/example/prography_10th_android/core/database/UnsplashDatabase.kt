package com.example.prography_10th_android.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.prography_10th_android.core.database.dao.BookmarkDao
import com.example.prography_10th_android.core.database.entity.BookmarkEntity

@Database(
    entities = [BookmarkEntity::class],
    version = 1
)
abstract class UnsplashDatabase : RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao
}
