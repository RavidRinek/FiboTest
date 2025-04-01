package com.test.fibotest.features.articles.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.test.fibotest.features.articles.domain.models.Article
import com.test.fibotest.ui.theme.AppColors

@Composable
fun ArticlesLazyColumn(
    scrollState: LazyListState,
    articles: List<Article>,
    groupClicked: (article: Article) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        state = scrollState
    ) {
        items(articles) { item ->
            Spacer(Modifier.height(12.dp))

            ArticleItem(
                article = item,
                itemClicked = {
                    groupClicked.invoke(it)
                },
            )

            Spacer(Modifier.height(12.dp))

            HorizontalDivider(color = AppColors.gray20)

            Spacer(Modifier.height(12.dp))
        }
    }
}