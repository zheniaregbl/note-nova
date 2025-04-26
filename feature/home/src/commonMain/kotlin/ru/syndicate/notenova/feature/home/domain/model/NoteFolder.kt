package ru.syndicate.notenova.feature.home.domain.model

import org.jetbrains.compose.resources.DrawableResource
import ru.syndicate.notenova.feature.home.resources.Res
import ru.syndicate.notenova.feature.home.resources.all_documents_svg
import ru.syndicate.notenova.feature.home.resources.archive_svg
import ru.syndicate.notenova.feature.home.resources.star_svg
import ru.syndicate.notenova.feature.home.resources.trash_svg

internal data class NoteFolder(
    val icon: DrawableResource,
    val title: String,
    val amount: Int = 0
)

internal val defaultFolders = listOf(
    NoteFolder(
        icon = Res.drawable.all_documents_svg,
        title = "All notes"
    ),
    NoteFolder(
        icon = Res.drawable.star_svg,
        title = "Favorite"
    ),
    NoteFolder(
        icon = Res.drawable.archive_svg,
        title = "Archive"
    ),
    NoteFolder(
        icon = Res.drawable.trash_svg,
        title = "Trash"
    )
)