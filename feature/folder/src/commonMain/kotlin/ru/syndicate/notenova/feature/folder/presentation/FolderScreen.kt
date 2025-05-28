package ru.syndicate.notenova.feature.folder.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.notenova.core.presentation.components.AddButton
import ru.syndicate.notenova.core.presentation.theme.colorPalette
import ru.syndicate.notenova.feature.folder.domain.model.Folder
import ru.syndicate.notenova.feature.folder.domain.model.Note
import ru.syndicate.notenova.feature.folder.presentation.components.NoteCard
import ru.syndicate.notenova.feature.folder.presentation.components.SearchBar
import ru.syndicate.notenova.feature.folder.resources.Res
import ru.syndicate.notenova.feature.folder.resources.arrow_back_svg
import ru.syndicate.notenova.feature.folder.resources.option_svg

internal class FolderScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        FolderScreenContent(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(top = 8.dp)
                .padding(horizontal = 8.dp),
            onBack = { navigator.pop() }
        )
    }
}

@Composable
internal fun FolderScreenContent(
    modifier: Modifier = Modifier,
    onBack: () -> Unit = { }
) {

    var searchText by remember { mutableStateOf("") }

    Box(modifier = modifier) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
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

                Text(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .basicMarquee(),
                    text = "Very very very very very very long name for folder",
                    style = LocalTextStyle.current,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                    maxLines = 1,
                    color = MaterialTheme.colorPalette.textColor
                )

                IconButton(onClick = { }) {
                    Image(
                        modifier = Modifier.size(28.dp),
                        painter = painterResource(Res.drawable.option_svg),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colorPalette.secondaryTextColor)
                    )
                }
            }

            SearchBar(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                value = searchText,
                hintText = "Search",
                onValueChange = { searchText = it }
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp)
            ) {

                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(top = 12.dp, bottom = 50.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    items(12) {

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

                        NoteCard(
                            modifier = Modifier.fillMaxWidth(),
                            note = note,
                            showFolderChip = true,
                            onClick = { }
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                0.0f to MaterialTheme.colorPalette.backgroundColor,
                                0.02f to Color.Transparent
                            )
                        )
                )
            }
        }

        AddButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 20.dp, bottom = 60.dp),
            onClick = { }
        )
    }
}