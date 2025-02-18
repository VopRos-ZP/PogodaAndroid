package ru.pogoda.ui.components.main

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import ru.pogoda.R
import ru.pogoda.ui.theme.MainColor
import ru.pogoda.ui.theme.PogodaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(component: MainComponent) {
    val state by component.state.collectAsState()

    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(topAppBarState)

    val weatherColor = PogodaTheme.colors.cloudyDay

    LaunchedEffect(topAppBarState) {
        Log.d("Main", "${topAppBarState.contentOffset}")
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(PogodaTheme.gradients.background)
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        containerColor = Color.Transparent,
        topBar = {
            CenterAlignedTopAppBar(
                scrollBehavior = scrollBehavior,
                title = {
                    Text(
                        text = state.fact.info?.country ?: "Loading",
                        style = MaterialTheme.typography.titleLarge,
                        color = MainColor
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { component.onFavoritesClick() }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_menu),
                            contentDescription = "Menu",
                            tint = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { component.onSettingsClick() }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_settings),
                            contentDescription = "Settings",
                            tint = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = weatherColor,
                    scrolledContainerColor = MaterialTheme.colorScheme.onSecondary
                )
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(PogodaTheme.gradients.background)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            TempBlock(
                temp = state.fact.fact?.temp?.toInt() ?: 0,
                secondTemp = state.fact.fact?.feels_like?.toInt() ?: 0,
                onHeightChange = { topAppBarState.contentOffset = it },
                color = weatherColor
            )
            HourlyForecastRow()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Погода на 10 дней",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium,
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = MaterialTheme.colorScheme.onSecondary,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    repeat(15) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(30.dp)
                        ) {
                            Text(
                                text = "Пн",
                                color = MaterialTheme.colorScheme.onSecondaryContainer,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.weight(0.5f)
                            )
                            Text(
                                text = "20 декабря",
                                color = MaterialTheme.colorScheme.secondary,
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier.weight(1f)
                            )
                            Image(
                                painterResource(R.drawable.onboarding),
                                contentDescription = null,
                                modifier = Modifier.size(22.dp)
                            )
                            Text(
                                text = "-8°",
                                color = MaterialTheme.colorScheme.primary,
                                style = MaterialTheme.typography.labelLarge
                            )
                            Text(
                                text = "-10°",
                                color = MaterialTheme.colorScheme.primary,
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { component.onDailyClick() }
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            ImageVector.vectorResource(R.drawable.today),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Погода на 15 дней",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    Icon(
                        ImageVector.vectorResource(R.drawable.arrow_forward),
                        contentDescription = null
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Текущие погодные условия",
                    style = MaterialTheme.typography.titleMedium,
                    color = MainColor
                )
                WeatherCard()
            }
        }
    }
}

@Composable
fun TempBlock(
    temp: Int,
    secondTemp: Int,
    onHeightChange: (Float) -> Unit,
    color: Color,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = color,
                shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
            )
            .padding(start = 16.dp, end = 16.dp, bottom = 30.dp)
            .onSizeChanged {
                Log.d("Main", "H -> ${it.toSize().height}")
                onHeightChange(it.toSize().height)
            }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "$temp°",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 80.sp,
                    color = MainColor
                )
            )
            Image(
                painterResource(R.drawable.onboarding),
                contentDescription = null,
                modifier = Modifier.size(227.dp)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Ясно",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = "Ощущается как $secondTemp°",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
            IconButton(
                onClick = {  }
            ) {
                Icon(
                    ImageVector.vectorResource(R.drawable.star_border),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        }
    }
}

@Composable
fun HourlyForecastRow() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Погода по часам",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(start = 16.dp)
        )
        ScrollableTabRow(
            selectedTabIndex = 0,
            containerColor = Color.Transparent,
            edgePadding = 16.dp,
            indicator = {
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(it[0]),
                    color = MaterialTheme.colorScheme.onSecondary,
                    height = 3.dp
                )
            },
            divider = { HorizontalDivider(color = MaterialTheme.colorScheme.onSecondary) }
        ) {
            repeat(10) {
                val selected = it == 0
                Tab(
                    selected = selected,
                    onClick = {},
                    text = {
                        Text(
                            text = "Сегодня",
                            color = if (selected) MaterialTheme.colorScheme.onSecondaryContainer
                            else MaterialTheme.colorScheme.secondary
                        )
                    }
                )
            }
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(10) {
                HourlyItem()
            }
        }
    }
}

@Composable
fun HourlyItem() {
    Column(
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.3f),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(vertical = 16.dp, horizontal = 9.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            painterResource(R.drawable.onboarding),
            contentDescription = null,
            modifier = Modifier.size(49.dp)
        )
        Text(
            text = "Сейчас",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = "-8°",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun WeatherCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.onSecondary,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 19.dp, vertical = 17.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            WeatherCardItem(
                resource = R.drawable.frame_65,
                name = "Ветер",
                value = ""
            )
            WeatherCardItem(
                resource = R.drawable.frame_68,
                name = "Порыв ветра",
                value = ""
            )
        }
        Row {
            WeatherCardItem(
                resource = R.drawable.today,
                name = "УФИ",
                value = ""
            )
            WeatherCardItem(
                resource = R.drawable.frame_67,
                name = "Влажность",
                value = ""
            )
        }
        Row {
            WeatherCardItem(
                resource = R.drawable.frame_66,
                name = "Давление",
                value = ""
            )
            WeatherCardItem(
                resource = R.drawable.frame_63,
                name = "Вер. осадков",
                value = ""
            )
        }
    }
}

@Composable
fun WeatherCardItem(
    resource: Int,
    name: String,
    value: String,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        ImageVector.vectorResource(resource).let {
            Icon(
                imageVector = it,
                contentDescription = it.name,
                modifier = Modifier.size(30.dp)
            )
        }
        Column {
            Text(
                text = name
            )
            Text(
                text = value
            )
        }
    }
}
