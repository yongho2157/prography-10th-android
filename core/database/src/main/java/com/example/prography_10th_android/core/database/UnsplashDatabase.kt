package com.example.prography_10th_android.core.database

import com.example.prography_10th_android.core.database.converter.StringListConverter
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.prography_10th_android.core.database.dao.BookmarkDao
import com.example.prography_10th_android.core.database.entity.BookmarkEntity

@Database(
    entities = [BookmarkEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(StringListConverter::class)
abstract class UnsplashDatabase : RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao
}
