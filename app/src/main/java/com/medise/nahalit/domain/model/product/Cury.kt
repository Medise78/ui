package com.medise.nahalit.domain.model.product


import com.google.gson.annotations.SerializedName

data class Cury(
    @SerializedName("href")
    val href: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("templated")
    val templated: Boolean
)