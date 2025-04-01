package com.test.fibotest.features.utilites

import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun utcToReadableEnglish(utc: String): String {
    val utcTime = ZonedDateTime.parse(utc)
    val localTime = utcTime.withZoneSameInstant(ZoneId.systemDefault())

    val formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy 'at' HH:mm", Locale.ENGLISH)
    return localTime.format(formatter)
}