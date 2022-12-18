package com.example.kitsu.data.remote

import com.example.kitsu.data.remote.apiservices.AnimeApiService
import com.example.kitsu.data.remote.apiservices.AuthApiService
import com.example.kitsu.data.remote.apiservices.MangaApiService
import com.example.kitsu.data.remote.interceptors.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/")
        .client(provideOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(provideLoggingInterceptor())
        .addInterceptor(TokenInterceptor())
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .callTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun provideLoggingInterceptor() = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    fun provideMangaApiService() = retrofitClient.create(MangaApiService::class.java)

    fun provideAnimeApiService() = retrofitClient.create(AnimeApiService::class.java)

    fun provideAuthApiService() = retrofitClient.create(AuthApiService::class.java)
}