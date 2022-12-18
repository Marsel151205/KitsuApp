package com.example.kitsu.di

import android.content.Context
import com.example.kitsu.data.local.sharedpreferences.PreferencesHelper
import com.example.kitsu.data.local.sharedpreferences.userdata.UserPreferencesData
import com.example.kitsu.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun provideMangaApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideMangaApiService()

    @Singleton
    @Provides
    fun provideAnimeApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideAnimeApiService()

    @Singleton
    @Provides
    fun provideAuthApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideAuthApiService()

    @Singleton
    @Provides
    fun providePreferencesHelper(@ApplicationContext context: Context) =
        PreferencesHelper(context)

    @Singleton
    @Provides
    fun provideUserPreferencesData(preferencesHelper: PreferencesHelper) =
        UserPreferencesData(preferencesHelper)
}