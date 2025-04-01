package com.test.fibotest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.test.fibotest.features.Second
import com.test.fibotest.features.articles.presentation.ArticlesNewsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationRoute.ARTICLES_NEWS) {
        composable(NavigationRoute.ARTICLES_NEWS) {
            ArticlesNewsScreen (
                navToDetailedArticleScreen = {
                    navController.navigate(NavigationRoute.SECOND) {
                        /*popUpTo(NavigationRoute.ARTICLES_NEWS) {
                            inclusive = true
                        }*/
                    }
                }
            )
        }

        composable(NavigationRoute.SECOND) {
            Second()
        }
    }
}
