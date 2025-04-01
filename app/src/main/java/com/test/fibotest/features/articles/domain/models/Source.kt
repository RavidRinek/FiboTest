package com.test.fibotest.features.articles.domain.models

import com.test.fibotest.features.articles.data.models.SourceResponse
import kotlinx.serialization.Serializable

@Serializable
data class Source(
    val id: String,
    val name: String,
)

fun SourceResponse.toDomain(): Source =
    Source(
        id = id ?: "",
        name = name ?: "",
    )