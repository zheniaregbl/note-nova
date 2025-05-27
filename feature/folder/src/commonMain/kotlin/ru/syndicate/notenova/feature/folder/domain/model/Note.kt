package ru.syndicate.notenova.feature.folder.domain.model

import kotlinx.datetime.LocalDate

internal data class Note(
    val id: Long,
    val title: String,
    val content: String,
    val folder: Folder,
    val lastUpdateDate: LocalDate
)
