package ru.syndicate.notenova.feature.note.navigation

import cafe.adriel.voyager.core.registry.screenModule
import ru.syndicate.notenova.core.navigation.SharedScreen
import ru.syndicate.notenova.feature.note.presentation.NoteScreen

val featureNoteScreenModule = screenModule {
    register<SharedScreen.NoteScreen> { NoteScreen() }
}