package com.example.prography_10th_android.core.data.di

import com.example.prography_10th_android.core.data.datasource.remote.UnsplashRemoteDataSource
import com.example.prography_10th_android.core.data.datasource.remote.UnsplashRemoteDataSourceImpl
import com.example.prography_10th_android.core.data.repository.UnsplashRepositoryImpl
import com.example.prography_10th_android.core.domain.repository.UnsplashRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

  @Binds
  fun bindsUnsplashRemoteDataSource(unsplashRemoteDataSourceImpl: UnsplashRemoteDataSourceImpl): UnsplashRemoteDataSource

  @Binds
  fun bindsUnsplashRepository(unsplashRepositoryImpl: UnsplashRepositoryImpl): UnsplashRepository

}
