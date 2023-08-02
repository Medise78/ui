package com.medise.nahalit.domain.model.product


import com.google.gson.annotations.SerializedName

data class WpTerm(
    @SerializedName("embeddable")
    val embeddable: Boolean,
    @SerializedName("href")
    val href: String,
    @SerializedName("taxonomy")
    val taxonomy: String
)