package com.test.fibotest.features.articles.data.repositories

import com.test.fibotest.features.articles.data.datasources.ArticlesRemoteDataSource
import com.test.fibotest.features.articles.data.models.GetArticlesNewsResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticlesRepositoryImpl @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val apiDataSource: ArticlesRemoteDataSource,
) : ArticlesRepository {

    override suspend fun getArticles(): Result<GetArticlesNewsResponse?> = withContext(dispatcher) {
        return@withContext apiDataSource.getArticles()
    }
}