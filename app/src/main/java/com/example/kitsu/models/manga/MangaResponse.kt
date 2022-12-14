package com.example.kitsu.models.manga

import androidx.paging.PagingData
import com.example.kitsu.models.Links
import com.example.kitsu.models.Meta
import com.google.gson.annotations.SerializedName

data class MangaResponse<T>(
    @SerializedName("data")
    val data: List<T>,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("links")
    val links: Links
)
