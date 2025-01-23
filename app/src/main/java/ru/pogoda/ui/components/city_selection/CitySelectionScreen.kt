package ru.pogoda.ui.components.city_selection

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pogoda.R
import ru.pogoda.ui.compose.BackTopBar
import ru.pogoda.ui.theme.PogodaTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CitySelectionScreen(component: CitySelectionComponent) {
    val state by component.state.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PogodaTheme.gradients.background)
    ) {
        BackTopBar(
            onClick = { component.onBackClick() },
            text = "Добавить местоположение",
        )
        SearchBar(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .offset(y = (-35).dp),
            text = state.search,
            onTextChanged = { component.onSearchChange(it) },
            leadingIcon = {
                Icon(
                    ImageVector.vectorResource(R.drawable.ic_menu),
                    contentDescription = null
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text: String,
    onTextChanged: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    androidx.compose.material3.SearchBar(
        modifier = modifier.fillMaxWidth(),
        inputField = {
            SearchBarDefaults.InputField(
                query = text,
                onQueryChange = { onTextChanged(it) },
                onSearch = { },
                expanded = false,
                onExpandedChange = {},
                placeholder = {
                    Text(
                        text = "Введите город",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Normal,
                            letterSpacing = 0.5.sp
                        )
                    )
                },
                leadingIcon = leadingIcon,
                trailingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_search),
                        contentDescription = null,
                    )
                },
            )
        },
        expanded = false,
        onExpandedChange = {},
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        )
    ) {}
}