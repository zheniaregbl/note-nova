package ru.syndicate.notenova.feature.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.notenova.core.presentation.theme.colorPalette
import ru.syndicate.notenova.feature.home.domain.model.NoteFolder

@Composable
internal fun NoteFolderItem(
    modifier: Modifier = Modifier,
    noteFolder: NoteFolder,
    onClick: () -> Unit
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(14.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(noteFolder.icon),
            contentDescription = null
        )

        Text(
            modifier = Modifier
                .weight(1f)
                .wrapContentWidth(Alignment.Start),
            text = noteFolder.title,
            style = LocalTextStyle.current,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorPalette.textColor
        )

        Text(
            modifier = Modifier
                .widthIn(min = 20.dp)
                .wrapContentWidth(Alignment.CenterHorizontally),
            text = noteFolder.amount.toString(),
            style = LocalTextStyle.current,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorPalette.secondaryTextColor
        )
    }
}