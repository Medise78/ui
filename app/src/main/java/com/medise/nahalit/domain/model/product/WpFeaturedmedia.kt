package com.medise.nahalit.domain.model.product


import com.google.gson.annotations.SerializedName

data class WpFeaturedmedia(
    @SerializedName("embeddable")
    val embeddable: Boolean,
    @SerializedName("href")
    val href: String
)