package com.example.prography_10th_android.core.database.di

import android.app.Application
import androidx.room.Room
import com.example.prography_10th_android.core.database.UnsplashDatabase
import com.example.prography_10th_android.core.database.dao.BookmarkDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application
    ): UnsplashDatabase {
        return Room
            .databaseBuilder(application, UnsplashDatabase::class.java, "unsplash.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideBookmarkDao(appDatabase: UnsplashDatabase): BookmarkDao {
        return appDatabase.bookmarkDao()
    }

}
