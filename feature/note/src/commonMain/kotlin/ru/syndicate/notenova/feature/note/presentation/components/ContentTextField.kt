package ru.syndicate.notenova.feature.note.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import ru.syndicate.notenova.core.presentation.theme.BlueAccent
import ru.syndicate.notenova.core.presentation.theme.colorPalette

@Composable
internal fun ContentTextField(
    modifier: Modifier = Modifier,
    value: String,
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
            value = value,
            onValueChange = onValueChange,
            textStyle = LocalTextStyle.current.copy(
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                lineHeight = 18.sp,
                color = MaterialTheme.colorPalette.textColor
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            cursorBrush = SolidColor(BlueAccent.copy(alpha = 0.8f))
        ) { innerTextField ->

            Box(modifier = Modifier.fillMaxWidth()) {

                innerTextField()

                if (value.isBlank())
                    Text(
                        text = "Текст...",
                        style = LocalTextStyle.current,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        lineHeight = 18.sp,
                        color = MaterialTheme.colorPalette.hintColor
                    )
            }
        }
    }
}