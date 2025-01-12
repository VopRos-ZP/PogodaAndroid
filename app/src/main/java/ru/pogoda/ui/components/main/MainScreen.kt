package ru.pogoda.ui.components.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import ru.pogoda.R
import ru.pogoda.ui.theme.PogodaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(component: MainComponent) {
    val state by component.state.collectAsState()

    WeatherScreen()

//    Scaffold(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(PogodaTheme.gradients.background),
//        containerColor = Color.Transparent,
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = {
//                    Text(
//                        text = state.fact.info?.country ?: "",
//                        style = MaterialTheme.typography.titleLarge,
//                        color = MaterialTheme.colorScheme.primary
//                    )
//                },
//                navigationIcon = {
//                    IconButton(onClick = { /* Навигация */ }) {
//                        Icon(
//                            imageVector = ImageVector.vectorResource(R.drawable.ic_menu),
//                            contentDescription = "Menu"
//                        )
//                    }
//                },
//                actions = {
//                    IconButton(onClick = { /* Настройки */ }) {
//                        Icon(
//                            imageVector = ImageVector.vectorResource(R.drawable.ic_settings),
//                            contentDescription = "Settings",
//                        )
//                    }
//                },
//                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
//                    containerColor = Color.Transparent
//                )
//            )
//        },
//    ) { padding ->
//        LazyColumn(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(padding)
//                .background(PogodaTheme.gradients.background)
//        ) {
//            item {
//                TempBlock()
//            }
//        }
//    }
}

@Composable
fun TempBlock() {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.CenterEnd
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomStart
        ) {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen() {
    val gradientBackground = Brush.verticalGradient(
        colors = listOf(Color(0xFF64B5F6), Color(0xFFBBDEFB))
    )

    Scaffold(
        containerColor = Color.Transparent,
        modifier = Modifier.background(gradientBackground),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Анапа",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu", tint = Color.White)
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Filled.Settings, contentDescription = "Settings", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Текущая погода
            CurrentWeatherSection()

            Spacer(modifier = Modifier.height(24.dp))

            // Погода по часам
            Text(
                text = "Погода по часам",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            HourlyForecastRow()

            Spacer(modifier = Modifier.height(24.dp))

            // Прогноз на 10 дней
            Text(
                text = "Погода на 10 дней",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            DailyForecastList()
        }
    }
}

@Composable
fun CurrentWeatherSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF64B5F6), RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "+3°",
            style = MaterialTheme.typography.displayLarge,
            color = Color.White
        )
        Text(
            text = "Ясно",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )
        Text(
            text = "Ощущается как +1°",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* Добавить в избранное */ }) {
            Text(text = "Добавить город в избранное")
        }
    }
}

@Composable
fun HourlyForecastRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(6) {
            Column(
                modifier = Modifier
                    .background(Color.White.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "${13 + it}:00", color = Color.White)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "-8°", color = Color.White)
            }
        }
    }
}

@Composable
fun DailyForecastList() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        repeat(5) { index ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = when (index) {
                        0 -> "Сегодня"
                        1 -> "Среда, 20 дек."
                        2 -> "Четверг, 21 дек."
                        else -> "День ${index + 1}"
                    },
                    color = Color.White
                )
                Text(text = "-8° / -10°", color = Color.White)
            }
        }
    }
}