package com.medise.nahalit.domain.model.search


import com.google.gson.annotations.SerializedName

data class SearchProductItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("subtype")
    val subtype: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)