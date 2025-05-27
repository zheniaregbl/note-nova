package ru.syndicate.notenova.feature.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.notenova.core.navigation.SharedScreen
import ru.syndicate.notenova.core.presentation.theme.colorPalette
import ru.syndicate.notenova.feature.home.domain.model.defaultFolders
import ru.syndicate.notenova.feature.home.presentation.components.NoteFolderItem
import ru.syndicate.notenova.feature.home.presentation.components.SectionHeader
import ru.syndicate.notenova.feature.home.resources.Res
import ru.syndicate.notenova.feature.home.resources.search_svg
import ru.syndicate.notenova.feature.home.resources.settings_svg

internal class HomeScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val folderScreen = rememberScreen(SharedScreen.FolderScreen)

        HomeScreenContent(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(top = 8.dp)
                .padding(horizontal = 8.dp),
            onNavigateToFolder = { navigator.push(folderScreen) }
        )
    }
}

@Composable
internal fun HomeScreenContent(
    modifier: Modifier = Modifier,
    onNavigateToFolder: () -> Unit = { }
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(onClick = { }) {
                Image(
                    modifier = Modifier.size(28.dp),
                    painter = painterResource(Res.drawable.settings_svg),
                    contentDescription = null
                )
            }

            Text(
                text = "Library",
                style = LocalTextStyle.current,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = MaterialTheme.colorPalette.textColor
            )

            IconButton(onClick = { }) {
                Image(
                    modifier = Modifier.size(28.dp),
                    painter = painterResource(Res.drawable.search_svg),
                    contentDescription = null
                )
            }
        }

        Box(modifier = Modifier.fillMaxSize()) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                item {
                    Column(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(MaterialTheme.colorPalette.cardColor)
                    ) {
                        defaultFolders.forEach { noteFolder ->
                            NoteFolderItem(
                                modifier = Modifier.fillMaxWidth(),
                                noteFolder = noteFolder,
                                onClick = onNavigateToFolder
                            )
                        }
                    }
                }

                item {

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {

                        SectionHeader(
                            modifier = Modifier.fillMaxWidth(),
                            title = "Folders"
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(MaterialTheme.colorPalette.cardColor)
                        ) {

                        }
                    }
                }

                item { Spacer(Modifier.height(50.dp)) }
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
}