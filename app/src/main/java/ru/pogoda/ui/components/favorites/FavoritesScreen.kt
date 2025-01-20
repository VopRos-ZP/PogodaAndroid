package ru.pogoda.ui.components.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import ru.pogoda.R
import ru.pogoda.ui.components.city_selection.SearchBar
import ru.pogoda.ui.theme.PogodaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(component: FavoritesComponent) {
    val state by component.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PogodaTheme.gradients.background),
    ) {
        TopAppBar(
            navigationIcon = {
                IconButton(
                    onClick = { component.onBackClick() }
                ) {
                    Icon(
                        ImageVector.vectorResource(R.drawable.ic_arrow_back),
                        contentDescription = null
                    )
                }
            },
            title = {
                Text(
                    text = "Избранное",
                    style = MaterialTheme.typography.titleLarge,
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent
            )
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