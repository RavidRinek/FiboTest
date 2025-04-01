package com.test.fibotest.navigation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
object ARTICLES_NEWS

@Serializable
data class ARTICLE_DETAILS(
    @SerialName("article") val article: String
)