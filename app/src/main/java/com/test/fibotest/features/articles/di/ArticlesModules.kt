package com.test.fibotest.features.articles.di

import com.test.fibotest.features.articles.data.datasources.ArticlesApiService
import com.test.fibotest.features.articles.data.datasources.ArticlesRemoteDataSource
import com.test.fibotest.features.articles.data.repositories.ArticlesRepository
import com.test.fibotest.features.articles.data.repositories.ArticlesRepositoryImpl
import com.test.fibotest.features.articles.data.repositories.MockArticlesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ArticlesModules {

    @Provides
    @Singleton
    fun provideArticlesApiService(retrofit: Retrofit): ArticlesApiService {
        return retrofit.create(ArticlesApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideArticlesRepository(
        remoteDataSource: ArticlesRemoteDataSource,
        dispatcher: CoroutineDispatcher
    ): ArticlesRepository {
//        return MockArticlesRepositoryImpl()
        return ArticlesRepositoryImpl(
            dispatcher,
            remoteDataSource,
        )
    }
}