package ru.syndicate.notenova

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import ru.syndicate.notenova.feature.folder.navigation.featureFolderScreenModule
import ru.syndicate.notenova.feature.home.navigation.featureHomeScreenModule
import ru.syndicate.notenova.feature.note.navigation.featureNoteScreenModule

fun main() {

    ScreenRegistry {
        featureHomeScreenModule()
        featureFolderScreenModule()
        featureNoteScreenModule()
    }

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Note Nova",
        ) { App() }
    }
}