package com.test.fibotest.features.articles.data.models

import com.google.gson.annotations.SerializedName

data class GetArticlesNewsResponse(
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("totalResults")
    val totalResults: Int? = null,
    @SerializedName("articles")
    val articlesResponse: List<ArticleResponse>? = null,
)