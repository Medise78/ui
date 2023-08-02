package com.medise.nahalit.domain.model.product


import com.google.gson.annotations.SerializedName

data class Logo(
    @SerializedName("caption")
    val caption: String,
    @SerializedName("contentUrl")
    val contentUrl: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("@id")
    val id: String,
    @SerializedName("inLanguage")
    val inLanguage: String,
    @SerializedName("@type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)