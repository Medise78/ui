package com.medise.nahalit.domain.model.product


import com.google.gson.annotations.SerializedName

data class VersionHistory(
    @SerializedName("count")
    val count: Int,
    @SerializedName("href")
    val href: String
)