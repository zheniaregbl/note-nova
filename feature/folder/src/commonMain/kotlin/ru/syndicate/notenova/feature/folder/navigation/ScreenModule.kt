package ru.syndicate.notenova.feature.folder.navigation

import cafe.adriel.voyager.core.registry.screenModule
import ru.syndicate.notenova.core.navigation.SharedScreen
import ru.syndicate.notenova.feature.folder.presentation.FolderScreen

val featureFolderScreenModule = screenModule {
    register<SharedScreen.FolderScreen> { FolderScreen() }
}