package ru.pogoda.ui.components.daily

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import ru.pogoda.R
import ru.pogoda.ui.components.main.DailyForecastList
import ru.pogoda.ui.theme.PogodaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyScreen(component: DailyComponent) {
    val state by component.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PogodaTheme.gradients.background),
    ) {
        TopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Transparent,
            ),
            navigationIcon = {
                IconButton(
                    onClick = { component.onBackClick() },
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
                    text = "Погода на 15 дней",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        )
        Text(
            text = "Москва",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        DailyForecastList()
    }
}