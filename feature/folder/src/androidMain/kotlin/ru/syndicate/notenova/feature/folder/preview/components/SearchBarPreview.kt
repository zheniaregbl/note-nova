package ru.syndicate.notenova.feature.folder.preview.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.syndicate.notenova.core.presentation.theme.AppTheme
import ru.syndicate.notenova.core.presentation.theme.colorPalette
import ru.syndicate.notenova.feature.folder.presentation.components.SearchBar

@Preview
@Composable
private fun SearchBarPreview() {
    AppTheme {
        Box(Modifier.background(MaterialTheme.colorPalette.backgroundColor)) {
            SearchBar(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                hintText = "Search",
                onValueChange = {}
            )
        }
    }
}