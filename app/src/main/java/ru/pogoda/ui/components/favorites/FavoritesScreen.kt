package ru.pogoda.ui.components.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.pogoda.ui.components.city_selection.SearchBar
import ru.pogoda.ui.compose.BackTopBar
import ru.pogoda.ui.theme.PogodaTheme

@Composable
fun FavoritesScreen(component: FavoritesComponent) {
    val state by component.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PogodaTheme.gradients.background),
    ) {
        BackTopBar(
            onClick = { component.onBackClick() },
            text = "Избранное",
        )
        SearchBar(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .offset(y = (-35).dp),
            text = state.search,
            onTextChanged = { component.onSearchChange(it) },
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            Column {

            }
            Column {

            }
        }
    }
}