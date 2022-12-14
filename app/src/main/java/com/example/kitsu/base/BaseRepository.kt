package com.example.kitsu.base

import com.example.kitsu.common.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.io.IOException

abstract class BaseRepository {

    fun <T> doRequest(result: suspend () -> T) = flow {
        emit(Resource.Loading())

        try {
            emit(Resource.Success(result()))
        } catch (exception: IOException) {
            emit(Resource.Error(exception.message.toString() ?: "Error"))
        }
    }
}

