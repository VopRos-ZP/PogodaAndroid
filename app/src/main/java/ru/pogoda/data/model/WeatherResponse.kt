package ru.pogoda.data.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val info: InfoBlock? = null,
    val fact: FactBlock? = null,
    val forecast_24: Map<String, ForecastDay>? = null,
    val forecast_6: Map<String, ForecastDay>? = null,
    val forecast_3: ForecastHourly? = null
)