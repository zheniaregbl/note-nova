package ru.syndicate.notenova.feature.folder.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.notenova.core.presentation.theme.BlueAccent
import ru.syndicate.notenova.core.presentation.theme.colorPalette
import ru.syndicate.notenova.feature.folder.domain.model.Note

@Composable
internal fun NoteCard(
    modifier: Modifier = Modifier,
    note: Note,
    showFolderChip: Boolean = true,
    onClick: () -> Unit
) {

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorPalette.cardColor)
            .clickable { onClick() }
            .padding(14.dp)
    ) {

        Text(
            text = note.lastUpdateDate.toString(),
            style = LocalTextStyle.current,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            color = BlueAccent
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = note.title,
            style = LocalTextStyle.current,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorPalette.textColor
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = note.content,
            style = LocalTextStyle.current,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorPalette.textColor
        )

        if (showFolderChip) {

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(100.dp))
                    .widthIn(max = 180.dp)
                    .background(BlueAccent)
                    .padding(horizontal = 8.dp, vertical = 2.dp),
                text = note.folder.title,
                style = LocalTextStyle.current,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorPalette.cardColor
            )
        }
    }
}