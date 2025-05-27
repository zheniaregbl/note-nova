package ru.syndicate.notenova

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import ru.syndicate.notenova.feature.folder.navigation.featureFolderScreenModule

class NoteApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ScreenRegistry {
            featureFolderScreenModule()
        }
    }
}