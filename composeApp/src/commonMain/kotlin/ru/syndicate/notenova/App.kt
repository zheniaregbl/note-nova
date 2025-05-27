package ru.syndicate.notenova

import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import ru.syndicate.notenova.core.presentation.theme.AppTheme
import ru.syndicate.notenova.core.presentation.theme.colorPalette
import ru.syndicate.notenova.feature.splash.presentation.SplashScreen

@Composable
internal fun App() {
    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorPalette.backgroundColor)
        ) {
            Navigator(SplashScreen()) { navigator ->
                FadeTransition(
                    navigator = navigator,
                    animationSpec = tween(
                        durationMillis = 180,
                        easing = Ease,
                        delayMillis = 100
                    )
                )
            }
        }
    }
}