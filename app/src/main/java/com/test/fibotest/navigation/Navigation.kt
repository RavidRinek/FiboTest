package com.test.fibotest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.test.fibotest.features.articles.presentation.ArticleDetailsScreen
import com.test.fibotest.features.articles.presentation.ArticlesNewsScreen
import kotlinx.serialization.json.Json

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ARTICLES_NEWS) {
        composable<ARTICLES_NEWS> {
            ArticlesNewsScreen(
                navToDetailedArticleScreen = {
                    navController.navigate(route = ARTICLE_DETAILS(Json.encodeToString(it)))
                }
            )
        }

        composable<ARTICLE_DETAILS> { entry ->
            ArticleDetailsScreen(article = Json.decodeFromString(entry.toRoute<ARTICLE_DETAILS>().article))
        }
    }
}