package com.test.fibotest.features.articles.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.test.fibotest.R
import com.test.fibotest.features.articles.domain.models.Article
import com.test.fibotest.features.utilites.utcToReadableEnglish

@Composable
fun ArticleItem(
    article: Article,
    itemClicked: (article: Article) -> Unit,
) {

    Column(modifier = Modifier
        .padding(horizontal = 12.dp)
        .clickable { itemClicked.invoke(article) }
    ) {
        Text(
            text = utcToReadableEnglish(article.publishedAt),
            style = MaterialTheme.typography.titleSmall,
            fontSize = 17.sp,
        )

        Spacer(Modifier.height(7.dp))

        AsyncImage(
            contentDescription = "",
            model = article.urlToImage,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.image_loading_placeholder),
            error = painterResource(R.drawable.image_error_placeholder),
        )

        Spacer(Modifier.height(7.dp))

        Text(text = article.title)
    }
}