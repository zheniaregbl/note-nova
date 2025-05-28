package ru.syndicate.notenova.feature.note.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.notenova.core.presentation.theme.colorPalette
import ru.syndicate.notenova.feature.note.presentation.components.ContentTextField
import ru.syndicate.notenova.feature.note.presentation.components.StyleRow
import ru.syndicate.notenova.feature.note.presentation.components.TitleTextField
import ru.syndicate.notenova.feature.note.resources.Res
import ru.syndicate.notenova.feature.note.resources.arrow_back_svg
import ru.syndicate.notenova.feature.note.resources.option_svg

internal class NoteScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        NoteScreenContent(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(top = 8.dp)
                .imePadding(),
            onBack = { navigator.pop() }
        )
    }
}

@Composable
internal fun NoteScreenContent(
    modifier: Modifier = Modifier,
    onBack: () -> Unit = { }
) {

    var titleText by remember { mutableStateOf("") }
    var contentText by remember { mutableStateOf("") }

    Box(modifier = modifier) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(onClick = onBack) {
                    Image(
                        modifier = Modifier.size(28.dp),
                        painter = painterResource(Res.drawable.arrow_back_svg),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colorPalette.secondaryTextColor)
                    )
                }

                IconButton(onClick = { }) {
                    Image(
                        modifier = Modifier.size(28.dp),
                        painter = painterResource(Res.drawable.option_svg),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colorPalette.secondaryTextColor)
                    )
                }
            }

            TitleTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                value = titleText,
                onValueChange = { titleText = it }
            )

            ContentTextField(
                modifier = Modifier
                    .padding(
                        top = 20.dp,
                        bottom = 100.dp
                    )
                    .fillMaxSize()
                    .padding(horizontal = 8.dp),
                value = contentText,
                onValueChange = { contentText = it }
            )
        }

        StyleRow(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
        )
    }
}