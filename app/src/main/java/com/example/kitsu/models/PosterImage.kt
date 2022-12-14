package com.example.kitsu.models

import com.google.gson.annotations.SerializedName

data class PosterImage(
    @SerializedName("original")
    val original: String,
    @SerializedName("small")
    val small: String,
    @SerializedName("medium")
    val medium: String
)
