package com.example.kitsu.models

import com.google.gson.annotations.SerializedName

data class CoverImage(
    @SerializedName("original")
    val original: String
)
