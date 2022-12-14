package com.example.kitsu.models.anime

import com.example.kitsu.base.IBaseDiffModel
import com.example.kitsu.models.Attributes
import com.google.gson.annotations.SerializedName

data class AnimeModel(
    @SerializedName("id")
    override val id: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("attributes")
    val attributes: Attributes
) : IBaseDiffModel<String>