package com.example.kitsu.models

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("canonicalTitle")
    val canonicalTitle: String,
    @SerializedName("averageRating")
    val averageRating: String,
    @SerializedName("popularityRank")
    val popularityRank: String,
    @SerializedName("ratingRank")
    val ratingRank: String,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("subtype")
    val subType: String,
    @SerializedName("coverImage")
    val coverImage: CoverImage,
    @SerializedName("posterImage")
    val posterImage: PosterImage
)