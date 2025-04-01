package com.test.fibotest.features.articles.data.models

import com.google.gson.annotations.SerializedName

data class SourceResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)