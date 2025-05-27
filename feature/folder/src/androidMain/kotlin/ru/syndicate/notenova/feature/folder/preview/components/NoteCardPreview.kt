package ru.syndicate.notenova.feature.folder.preview.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import ru.syndicate.notenova.core.presentation.theme.AppTheme
import ru.syndicate.notenova.core.presentation.theme.colorPalette
import ru.syndicate.notenova.feature.folder.domain.model.Folder
import ru.syndicate.notenova.feature.folder.domain.model.Note
import ru.syndicate.notenova.feature.folder.presentation.components.NoteCard

@Preview
@Composable
private fun NoteCardPreview() {

    val note = Note(
        id = 0,
        title = "Some note",
        content = "Very very very very very very very long content for this note.",
        folder = Folder(
            id = 0,
            title = "Work"
        ),
        lastUpdateDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    )

    AppTheme {
        Box(Modifier.background(MaterialTheme.colorPalette.backgroundColor)) {
            NoteCard(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                note = note,
                onClick = { }
            )
        }
    }
}