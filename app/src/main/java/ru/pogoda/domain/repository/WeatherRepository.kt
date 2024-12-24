package ru.pogoda.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.pogoda.data.model.WeatherResponse

interface WeatherRepository {
    val weather: Flow<WeatherResponse>
}