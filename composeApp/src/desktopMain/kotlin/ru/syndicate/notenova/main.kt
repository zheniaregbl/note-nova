package ru.syndicate.notenova

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import ru.syndicate.notenova.feature.folder.navigation.featureFolderScreenModule

fun main() {

    ScreenRegistry {
        featureFolderScreenModule()
    }

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Note Nova",
        ) { App() }
    }
}