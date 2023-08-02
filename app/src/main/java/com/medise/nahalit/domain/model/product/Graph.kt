package com.medise.nahalit.domain.model.product


import com.google.gson.annotations.SerializedName
import com.medise.nahalit.domain.model.*

data class Graph(
    @SerializedName("breadcrumb")
    val breadcrumb: Breadcrumb,
    @SerializedName("dateModified")
    val dateModified: String,
    @SerializedName("datePublished")
    val datePublished: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("@id")
    val id: String,
    @SerializedName("image")
    val image: Image,
    @SerializedName("inLanguage")
    val inLanguage: String,
    @SerializedName("isPartOf")
    val isPartOf: IsPartOf,
    @SerializedName("itemListElement")
    val itemListElement: List<ItemElement>,
    @SerializedName("logo")
    val logo: Logo,
    @SerializedName("name")
    val name: String,
    @SerializedName("potentialAction")
    val potentialAction: List<PotentialAction>,
    @SerializedName("publisher")
    val publisher: Publisher,
    @SerializedName("sameAs")
    val sameAs: List<String>,
    @SerializedName("@type")
    val type: String,
    @SerializedName("url")
    val url: String
)