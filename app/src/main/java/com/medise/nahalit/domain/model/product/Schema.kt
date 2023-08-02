package com.medise.nahalit.domain.model.product


import com.google.gson.annotations.SerializedName

data class Schema(
    @SerializedName("@context")
    val context: String,
    @SerializedName("@graph")
    val graph: List<Graph>
)