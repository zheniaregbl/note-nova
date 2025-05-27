package ru.syndicate.notenova.feature.home.navigation

import cafe.adriel.voyager.core.registry.screenModule
import ru.syndicate.notenova.core.navigation.SharedScreen
import ru.syndicate.notenova.feature.home.presentation.HomeScreen

val featureHomeScreenModule = screenModule {
    register<SharedScreen.HomeScreen> { HomeScreen() }
}