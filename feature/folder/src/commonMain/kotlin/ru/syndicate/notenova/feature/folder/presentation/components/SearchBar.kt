package ru.syndicate.notenova.feature.folder.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.notenova.core.presentation.theme.BlueAccent
import ru.syndicate.notenova.core.presentation.theme.colorPalette
import ru.syndicate.notenova.feature.folder.resources.Res
import ru.syndicate.notenova.feature.folder.resources.filter_svg
import ru.syndicate.notenova.feature.folder.resources.search_svg

@Composable
internal fun SearchBar(
    modifier: Modifier = Modifier,
    value: String,
    hintText: String,
    onValueChange: (String) -> Unit
) {

    CompositionLocalProvider(
        LocalTextSelectionColors provides TextSelectionColors(
            handleColor = BlueAccent.copy(alpha = 0.8f),
            backgroundColor = BlueAccent.copy(alpha = 0.4f)
        )
    ) {
        BasicTextField(
            modifier = modifier,
            textStyle = LocalTextStyle.current.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                lineHeight = 14.sp,
                color = MaterialTheme.colorPalette.textColor
            ),
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            cursorBrush = SolidColor(BlueAccent.copy(alpha = 0.8f))
        ) { innerTextField ->

            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(100.dp))
                    .fillMaxWidth()
                    .background(MaterialTheme.colorPalette.cardColor)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 10.dp
                    ),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(Res.drawable.search_svg),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorPalette.secondaryTextColor)
                )

                Box(modifier = Modifier.weight(1f)) {

                    innerTextField()

                    if (value.isBlank())
                        Text(
                            text = hintText,
                            style = LocalTextStyle.current,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            lineHeight = 14.sp,
                            color = MaterialTheme.colorPalette.secondaryTextColor
                        )
                }

                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(Res.drawable.filter_svg),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorPalette.secondaryTextColor)
                )
            }
        }
    }
}