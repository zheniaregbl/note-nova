package ru.syndicate.notenova.core.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {
    data object HomeScreen : SharedScreen()
    data object FolderScreen : SharedScreen()
}