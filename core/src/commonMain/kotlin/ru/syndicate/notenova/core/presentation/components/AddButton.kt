package ru.syndicate.notenova.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import note_nova.core.generated.resources.Res
import note_nova.core.generated.resources.plus_svg
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.notenova.core.presentation.theme.BlueAccent
import ru.syndicate.notenova.core.presentation.theme.colorPalette

@Composable
fun AddButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(BlueAccent)
            .clickable { onClick() }
            .padding(18.dp)
    ) {
        Image(
            modifier = Modifier.size(20.dp),
            painter = painterResource(Res.drawable.plus_svg),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorPalette.backgroundColor)
        )
    }
}