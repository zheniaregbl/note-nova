package ru.syndicate.notenova.feature.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.notenova.core.presentation.theme.colorPalette
import ru.syndicate.notenova.feature.home.resources.Res
import ru.syndicate.notenova.feature.home.resources.plus_svg

@Composable
internal fun SectionHeader(
    modifier: Modifier = Modifier,
    title: String
) {

    Row(
        modifier = modifier.padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            style = LocalTextStyle.current,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = MaterialTheme.colorPalette.textColor
        )

        IconButton(onClick = { }) {
            Image(
                modifier = Modifier.size(25.dp),
                painter = painterResource(Res.drawable.plus_svg),
                contentDescription = null
            )
        }
    }
}