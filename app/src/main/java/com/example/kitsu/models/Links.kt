package com.example.kitsu.models

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("first")
    val first: String,
    @SerializedName("prev")
    val prev: String,
    @SerializedName("next")
    val next: String,
    @SerializedName("last")
    val last: String
)
