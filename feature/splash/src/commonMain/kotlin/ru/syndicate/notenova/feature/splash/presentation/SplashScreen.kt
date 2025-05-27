package ru.syndicate.notenova.feature.splash.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.notenova.core.navigation.SharedScreen
import ru.syndicate.notenova.core.presentation.theme.BlueAccent
import ru.syndicate.notenova.feature.splash.resources.Res
import ru.syndicate.notenova.feature.splash.resources.book_svg

class SplashScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val homeScreen = rememberScreen(SharedScreen.HomeScreen)

        SplashScreenContent(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            navigateToNext = { navigator.replace(homeScreen) }
        )
    }
}

@Composable
internal fun SplashScreenContent(
    modifier: Modifier = Modifier,
    navigateToNext: () -> Unit = { }
) {

    var isVisibleLogo by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        isVisibleLogo = true
        delay(1200)
        navigateToNext()
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = isVisibleLogo,
            enter = fadeIn(
                animationSpec = tween(
                    durationMillis = 500,
                    easing = EaseIn
                )
            ),
            exit = ExitTransition.None
        ) {
            Image(
                modifier = Modifier.size(140.dp),
                painter = painterResource(Res.drawable.book_svg),
                contentDescription = null,
                colorFilter = ColorFilter.tint(BlueAccent)
            )
        }
    }
}