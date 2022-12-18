package com.example.kitsu.data.repositories

import com.example.kitsu.base.BaseRepository
import com.example.kitsu.data.remote.apiservices.AuthApiService
import com.example.kitsu.models.auth.AuthModel
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val service: AuthApiService
) : BaseRepository() {

    fun postDataUser(model: AuthModel) = doRequest {
        service.postDataUser(model)
    }
}