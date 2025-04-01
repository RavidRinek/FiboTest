package com.test.fibotest.features.articles.data.repositories

import com.test.fibotest.features.articles.data.models.GetArticlesNewsResponse

interface ArticlesRepository {

    suspend fun getArticles(): Result<GetArticlesNewsResponse?>
}

//8c6b64585c0943a79b16d773cd8adefa