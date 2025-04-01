package com.test.fibotest.features.articles.domain.models

import androidx.compose.ui.util.fastMap
import com.test.fibotest.features.articles.data.models.GetArticlesNewsResponse

data class ArticlesNews(
    val totalResults: Int,
    val articles: List<Article>,
)

fun GetArticlesNewsResponse.toDomain(): ArticlesNews =
    ArticlesNews(
        totalResults = totalResults ?: 0,
        articles = (articlesResponse ?: listOf()).fastMap { it.toDomain() }
    )