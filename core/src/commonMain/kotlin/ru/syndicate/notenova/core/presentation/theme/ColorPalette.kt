package ru.syndicate.notenova.core.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

enum class ThemeMode {
    LIGHT,
    DARK
}

data class ColorPalette(
    val backgroundColor: Color,
    val textColor: Color,
    val secondaryTextColor: Color,
    val cardColor: Color,
    val themeMode: ThemeMode
)

val LightColorPalette = ColorPalette(
    backgroundColor = LightBackgroundColor,
    textColor = LightTextColor,
    secondaryTextColor = LightSecondaryTextColor,
    cardColor = Color.White,
    themeMode = ThemeMode.LIGHT
)

val DarkColorPalette = ColorPalette(
    backgroundColor = DarkBackgroundColor,
    textColor = DarkTextColor,
    secondaryTextColor = DarkSecondaryTextColor,
    cardColor = DarkCardColor,
    themeMode = ThemeMode.DARK
)

val LocalColorPalette = staticCompositionLocalOf { LightColorPalette }

val MaterialTheme.colorPalette: ColorPalette
    @Composable
    @ReadOnlyComposable
    get() = LocalColorPalette.current
