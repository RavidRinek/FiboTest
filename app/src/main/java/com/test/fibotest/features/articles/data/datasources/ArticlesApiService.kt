package com.test.fibotest.features.articles.data.datasources

import com.test.fibotest.features.articles.data.models.GetArticlesNewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticlesApiService {

    @GET(GET_ARTICLES)
    suspend fun getArticles(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String = "8c6b64585c0943a79b16d773cd8adefa"
    ): Response<GetArticlesNewsResponse>

    companion object {
        private const val GET_ARTICLES = "everything"
    }
}