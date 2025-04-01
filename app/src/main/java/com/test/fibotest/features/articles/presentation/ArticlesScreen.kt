package com.test.fibotest.features.articles.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.test.fibotest.features.articles.domain.models.Article
import com.test.fibotest.features.articles.presentation.components.ArticlesLazyColumn
import com.test.fibotest.features.utilites.EmptyScreenState
import com.test.fibotest.features.utilites.LoadingScreen
import com.test.fibotest.features.utilites.LoadingStateItemsColumn
import com.test.fibotest.features.utilites.rememberLifecycleEvent
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun ArticlesNewsScreen(navToDetailedArticleScreen: (Article) -> Unit) {

    val viewModel: ArticlesViewModel = hiltViewModel()
    val state = viewModel.collectAsState()
    val context = LocalContext.current
    val lifecycleEvent = rememberLifecycleEvent()

    LaunchedEffect(lifecycleEvent.value) {
        if (lifecycleEvent.value == Lifecycle.Event.ON_RESUME) {
            viewModel.sendAction(ArticlesViewModel.Action.ScreenResumed)
        }
        /*if (lifecycleEvent.value == Lifecycle.Event.ON_STOP) {
            viewModel.sendAction(ArticlesViewModel.Action.ScreenStopped)
        }*/
    }

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is ArticlesViewModel.SideEffect.ShowToast -> {
                Toast.makeText(
                    context,
                    sideEffect.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

            is ArticlesViewModel.SideEffect.NavToDetailedArticleScreen -> {
                navToDetailedArticleScreen.invoke(sideEffect.article)
            }
        }
    }

    Column {
        when (val res = state.value.uiState) {
            is ArticlesViewModel.UiStates.Loading -> {
                if (res.initLoader) {
                    LoadingStateItemsColumn()
                } else {
                    LoadingScreen()
                }
            }

            ArticlesViewModel.UiStates.Error -> {
                EmptyScreenState("Could not get any relevant data")
            }

            is ArticlesViewModel.UiStates.NotEmpty -> {
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    text = "We found ${res.articlesNews.totalResults} articles",
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 24.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(24.dp))

                ArticlesLazyColumn(
                    articles = res.articlesNews.articles,
                    groupClicked = {
                        viewModel.sendAction(
                            ArticlesViewModel
                                .Action
                                .ArticleClicked(it)
                        )
                    }
                )
            }
        }
    }
}