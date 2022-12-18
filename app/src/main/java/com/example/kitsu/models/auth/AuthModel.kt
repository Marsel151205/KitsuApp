package com.example.kitsu.models.auth

import com.google.gson.annotations.SerializedName

data class AuthModel(
    @SerializedName("grant_type")
    val grantType: String = "password",
    @SerializedName("username")
    val email: String,
    @SerializedName("password")
    val password: String
)
