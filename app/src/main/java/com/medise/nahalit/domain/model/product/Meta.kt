package com.medise.nahalit.domain.model.product


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("_analytify_skip_tracking")
    val analytifySkipTracking: Boolean
)