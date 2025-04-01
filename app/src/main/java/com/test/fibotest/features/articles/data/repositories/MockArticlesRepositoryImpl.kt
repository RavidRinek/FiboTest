package com.test.fibotest.features.articles.data.repositories

import com.test.fibotest.features.articles.data.models.ArticleResponse
import com.test.fibotest.features.articles.data.models.GetArticlesNewsResponse
import com.test.fibotest.features.articles.data.models.SourceResponse

class MockArticlesRepositoryImpl : ArticlesRepository {

    override suspend fun getArticles(): Result<GetArticlesNewsResponse?> {
//        return Result.failure(Throwable("XXX"))
        return Result.success(
            GetArticlesNewsResponse(
                status = "ok",
                totalResults = 1,
                articlesResponse = listOf(
                    ArticleResponse(
                        sourceResponse = SourceResponse(
                            id = "1",
                            name = "test"
                        ),
                        author = "test",
                        title = "test",
                        description = "test",
                        url = "test",
                        urlToImage = "test",
                        publishedAt = "test",
                        content = "test"
                    ),
                    ArticleResponse(
                        sourceResponse = SourceResponse(
                            id = "2",
                            name = "test2"
                        ),
                        author = "test2",
                        title = "test2",
                        description = "test2",
                        url = "test2",
                        urlToImage = "test2",
                        publishedAt = "test2",
                        content = "test2"
                    )
                )
            )
        )
    }

}