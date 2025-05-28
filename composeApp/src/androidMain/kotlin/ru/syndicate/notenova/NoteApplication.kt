package ru.syndicate.notenova

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import ru.syndicate.notenova.feature.folder.navigation.featureFolderScreenModule
import ru.syndicate.notenova.feature.home.navigation.featureHomeScreenModule
import ru.syndicate.notenova.feature.note.navigation.featureNoteScreenModule

class NoteApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ScreenRegistry {
            featureHomeScreenModule()
            featureFolderScreenModule()
            featureNoteScreenModule()
        }
    }
}