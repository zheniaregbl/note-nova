package ru.syndicate.notenova.feature.note.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.notenova.core.presentation.theme.colorPalette
import ru.syndicate.notenova.feature.note.resources.Res
import ru.syndicate.notenova.feature.note.resources.bold_svg
import ru.syndicate.notenova.feature.note.resources.delete_line_svg
import ru.syndicate.notenova.feature.note.resources.italic_svg
import ru.syndicate.notenova.feature.note.resources.link_svg
import ru.syndicate.notenova.feature.note.resources.list_svg
import ru.syndicate.notenova.feature.note.resources.underline_svg
import ru.syndicate.notenova.feature.note.resources.unlink_svg

@Composable
internal fun StyleRow(
    modifier: Modifier = Modifier
) {

    val styleOption = listOf(
        Res.drawable.bold_svg,
        Res.drawable.italic_svg,
        Res.drawable.underline_svg,
        Res.drawable.delete_line_svg,
        Res.drawable.link_svg,
        Res.drawable.unlink_svg,
        Res.drawable.list_svg
    )

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(100.dp))
            .background(MaterialTheme.colorPalette.cardColor)
    ) {
        styleOption.forEach {
            Box(
                modifier = Modifier
                    .clickable {  }
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(it),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorPalette.secondaryTextColor)
                )
            }
        }
    }
}