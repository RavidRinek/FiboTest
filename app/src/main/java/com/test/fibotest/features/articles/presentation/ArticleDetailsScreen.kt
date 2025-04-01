package com.test.fibotest.features.articles.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.test.fibotest.R
import com.test.fibotest.features.articles.domain.models.Article
import com.test.fibotest.features.utilites.HyperlinkText

@Composable
fun ArticleDetailsScreen(article: Article) {

    Column {
        AsyncImage(
            contentDescription = "",
            model = article.urlToImage,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.image_loading_placeholder),
            error = painterResource(R.drawable.image_error_placeholder),
        )

        Spacer(Modifier.height(12.dp))

        Text(
            text = "${article.source.name} by ${article.author}",
            style = MaterialTheme.typography.titleSmall,
            fontSize = 17.sp
        )
        Spacer(Modifier.height(12.dp))

        Text(text = article.description)

        Spacer(Modifier.height(7.dp))

        Text(text = article.content)

        Spacer(Modifier.height(24.dp))

        HyperlinkText(
            url = article.url,
            text = "Click here to enter full article"
        )
    }
}