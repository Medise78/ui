package com.medise.nahalit.domain.model.product


import com.google.gson.annotations.SerializedName

data class IsPartOf(
    @SerializedName("@id")
    val id: String
)