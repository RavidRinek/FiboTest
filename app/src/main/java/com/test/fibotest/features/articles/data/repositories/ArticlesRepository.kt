package com.test.fibotest.features.articles.data.repositories

import com.test.fibotest.features.articles.data.models.GetArticlesNewsResponse

interface ArticlesRepository {

    suspend fun getArticles(): Result<GetArticlesNewsResponse?>
}