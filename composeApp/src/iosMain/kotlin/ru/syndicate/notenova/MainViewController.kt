package ru.syndicate.notenova

import androidx.compose.ui.window.ComposeUIViewController
import cafe.adriel.voyager.core.registry.ScreenRegistry
import ru.syndicate.notenova.feature.folder.navigation.featureFolderScreenModule
import ru.syndicate.notenova.feature.home.navigation.featureHomeScreenModule
import ru.syndicate.notenova.feature.note.navigation.featureNoteScreenModule

fun MainViewController() = ComposeUIViewController(
    configure = {
        ScreenRegistry {
            featureHomeScreenModule()
            featureFolderScreenModule()
            featureNoteScreenModule()
        }
    }
) { App() }