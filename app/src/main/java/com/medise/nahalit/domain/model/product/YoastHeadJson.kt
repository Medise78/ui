package com.medise.nahalit.domain.model.product


import com.google.gson.annotations.SerializedName

data class YoastHeadJson(
    @SerializedName("article_modified_time")
    val articleModifiedTime: String,
    @SerializedName("canonical")
    val canonical: String,
    @SerializedName("og_description")
    val ogDescription: String,
    @SerializedName("og_image")
    val ogImage: List<OgImage>,
    @SerializedName("og_locale")
    val ogLocale: String,
    @SerializedName("og_site_name")
    val ogSiteName: String,
    @SerializedName("og_title")
    val ogTitle: String,
    @SerializedName("og_type")
    val ogType: String,
    @SerializedName("og_url")
    val ogUrl: String,
    @SerializedName("robots")
    val robots: Robots,
    @SerializedName("title")
    val title: String,
    @SerializedName("schema")
    val schema: Schema
)