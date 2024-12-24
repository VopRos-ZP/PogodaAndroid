package ru.pogoda.ui.components.city_selection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pogoda.R
import ru.pogoda.ui.theme.PogodaTheme

@Composable
fun CitySelectionScreen(component: CitySelectionComponent) {
    val state by component.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PogodaTheme.gradients.background),
    ) {
        TopBar()
        SearchBar(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = state.search,
            onTextChanged = { component.onSearchChange(it) }
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent,
        ),
        navigationIcon = {
            IconButton(
                onClick = {

                },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.secondary
                )
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_back),
                    contentDescription = null,
                )
            }
        },
        title = {
            Text(
                text = "Добавить местоположение",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text: String,
    onTextChanged: (String) -> Unit,
) {
    androidx.compose.material3.SearchBar(
        modifier = modifier
            .fillMaxWidth()
            .semantics { traversalIndex = 0f },
        inputField = {
            SearchBarDefaults.InputField(
                query = text,
                onQueryChange = { onTextChanged(it) },
                onSearch = {  },
                expanded = false,
                onExpandedChange = {  },
                placeholder = {
                    Text(
                        text = "Введите город",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Normal,
                            letterSpacing = 0.5.sp
                        )
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_menu),
                        contentDescription = null,
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_search),
                        contentDescription = null,
                    )
                },
            )
        },
        expanded = false,
        onExpandedChange = {  },
    ) {}
}