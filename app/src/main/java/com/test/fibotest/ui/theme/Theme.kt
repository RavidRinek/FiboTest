package com.test.fibotest.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

//     Other default colors to override

)

data object AppColors {
    val background = Color(0xFFFFFBFE)
    val surface = Color(0xFFFFFBFE)
    val onPrimary = Color.White
    val onSecondary = Color.White
    val onTertiary = Color.White
    val onBackground = Color(0xFF1C1B1F)
    val onSurface = Color(0xFF1C1B1F)
    val gray100 = Color(0xFF218CCC)

    val gray05 = Color(0xFFF5F5F5)
    val gray10 = Color(0xFFEAEAEA)
    val gray20 = Color(0xFFD7D7D7)
    val gray40 = Color(0xFFAFAFAF)
    val gray50 = Color(0xFF9A9A9A)
    val gray60 = Color(0xFF868686)
    val gray70 = Color(0xFF727272)
    val gray80 = Color(0xFF5E5E5E)
    val gray90 = Color(0xFF4A4A4A)
    val test = Color(0xFF414141)
}

@Composable
fun FiboTestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}