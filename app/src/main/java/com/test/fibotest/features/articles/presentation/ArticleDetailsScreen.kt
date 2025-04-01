package com.test.fibotest.features.articles.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.test.fibotest.features.utilites.HyperlinkText
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun ArticleDetailsScreen() {

    val viewModel: ArticlesViewModel = hiltViewModel()
    val state = viewModel.collectAsState()
    val article = state.value.selectedArticle

    Column {
        AsyncImage(
            contentDescription = "",
            model = article?.urlToImage,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop,
            placeholder = rememberVectorPainter(image = Icons.Outlined.Refresh),
            error = rememberVectorPainter(image = Icons.Outlined.Delete),
        )

        Spacer(Modifier.height(7.dp))

        Text(
            text = "${article?.source?.name} by ${article?.author}",
            style = MaterialTheme.typography.titleSmall,
            fontSize = 17.sp
        )
        Spacer(Modifier.height(7.dp))

        Text(text = article?.description?:"")

        Spacer(Modifier.height(7.dp))

        Text(text = article?.content?:"")

        Spacer(Modifier.height(7.dp))

        HyperlinkText(
            url = article?.url?:"",
            text = "Click here to enter full article"
        )
    }
}