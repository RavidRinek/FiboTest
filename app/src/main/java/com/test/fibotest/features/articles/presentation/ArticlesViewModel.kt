package com.test.fibotest.features.articles.presentation

import androidx.lifecycle.ViewModel
import com.test.fibotest.features.articles.domain.models.Article
import com.test.fibotest.features.articles.domain.models.ArticlesNews
import com.test.fibotest.features.articles.domain.usecases.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase,
) : ViewModel(), ContainerHost<ArticlesViewModel.State, ArticlesViewModel.SideEffect> {

    override val container: Container<State, SideEffect> = container(State())
    private var initLoaderState: Boolean = true

    fun sendAction(action: Action) {
        when (action) {
            Action.ScreenResumed -> {
                intent {
                    reduce { state.copy(uiState = UiStates.Loading(initLoaderState)) }
                    getArticlesUseCase().onSuccess {
                        reduce {
                            state.copy(
                                uiState = UiStates.NotEmpty(
                                    articlesNews = ArticlesNews(
                                        totalResults = it!!.totalResults, //validated for null/empty in usecase
                                        articles = it.articles
                                    )
                                ),
//                                articles = it.articles
                            )
                        }
                    }.onFailure {
                        reduce { state.copy(uiState = UiStates.Error) }
                        postSideEffect(
                            SideEffect.ShowToast(
                                it.message ?: "Something went wrong"
                            )
                        )
                    }
                    initLoaderState = false
                }
            }

            is Action.ArticleClicked -> {
                intent {
                    reduce { state.copy(selectedArticle = action.article) }
                    postSideEffect(SideEffect.NavToDetailedArticleScreen(action.article))
                }
            }
        }
    }

    sealed class UiStates {
        data class Loading(val initLoader: Boolean) : UiStates()
        data object Error : UiStates()
        data class NotEmpty(val articlesNews: ArticlesNews) : UiStates()
    }

    data class State(
        val uiState: UiStates = UiStates.Loading(true),
        val selectedArticle: Article? = null
    )

    sealed class SideEffect {
        data class ShowToast(val message: String) : SideEffect()
        data class NavToDetailedArticleScreen(val article: Article) : SideEffect()
    }

    sealed class Action {
        data object ScreenResumed : Action()
        data class ArticleClicked(val article: Article) : Action()
    }
}
