package com.example.kitsu.data.remote.apiservices

import com.example.kitsu.models.auth.AuthModel
import com.example.kitsu.models.auth.TokenModel
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApiService {

    @POST("oauth/token")
    suspend fun postDataUser(
        @Body authModel: AuthModel
    ): TokenModel
}