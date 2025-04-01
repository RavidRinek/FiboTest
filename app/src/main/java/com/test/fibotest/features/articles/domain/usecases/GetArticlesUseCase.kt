package com.test.fibotest.features.articles.domain.usecases

import com.test.fibotest.features.articles.data.repositories.ArticlesRepository
import com.test.fibotest.features.articles.domain.models.ArticlesNews
import com.test.fibotest.features.articles.domain.models.toDomain
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val articlesRepository: ArticlesRepository,
) {
    suspend operator fun invoke(): Result<ArticlesNews?> {
        val res = articlesRepository.getArticles().onSuccess {
            if (it == null || it.articlesResponse.isNullOrEmpty()) {
                return Result.failure(Throwable("Could not get any articles"))
            }
        }
        return res.map { it?.toDomain() }
    }
}