package com.medise.nahalit.domain.model.product


import com.google.gson.annotations.SerializedName

data class ProductItem(
    @SerializedName("comment_status")
    val commentStatus: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("excerpt")
    val excerpt: Excerpt,
    @SerializedName("id")
    val id: Int,
    @SerializedName("link")
    val link: String,
    @SerializedName("_links")
    val links: Links,
    @SerializedName("product_cat")
    val productCat: List<Int>,
    @SerializedName("product_tag")
    val productTag: List<Any>,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("yoast_head_json")
    val yoastHeadJson: YoastHeadJson
)