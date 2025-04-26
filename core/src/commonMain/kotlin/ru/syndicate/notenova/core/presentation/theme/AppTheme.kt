package ru.syndicate.notenova.core.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(
    themeMode: ThemeMode = ThemeMode.LIGHT,
    content: @Composable () -> Unit
) {

    val palette = when (themeMode) {
        ThemeMode.LIGHT -> LightColorPalette
        ThemeMode.DARK -> DarkColorPalette
    }

    CompositionLocalProvider(LocalColorPalette provides palette) {
        MaterialTheme(
            colorScheme = lightColorScheme(),
            content = content
        )
    }
}