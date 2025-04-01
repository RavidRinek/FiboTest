package com.test.fibotest.features.articles.data.datasources

import com.test.fibotest.features.articles.data.models.GetArticlesNewsResponse
import javax.inject.Inject

//this should extend some kind of 'BaseApiDataSource' to handle errors and etc..
class ArticlesRemoteDataSource @Inject constructor(
    private val api: ArticlesApiService,
) {

    suspend fun getArticles(): Result<GetArticlesNewsResponse?> {
        return try {
            val response = api.getArticles("bitcoin")
            Result.success(response.body())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}