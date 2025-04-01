package com.test.fibotest.features.articles.domain.models

import com.test.fibotest.features.articles.data.models.ArticleResponse
import com.test.fibotest.features.articles.data.models.SourceResponse

data class Article(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String,
)

fun ArticleResponse.toDomain(): Article =
    Article(
        source = (sourceResponse ?: SourceResponse()).toDomain(),
        author = author ?: "",
        title = title ?: "",
        description = description ?: "",
        url = url ?: "",
        urlToImage = urlToImage ?: "",
        publishedAt = publishedAt ?: "",
        content = content ?: "",
    )