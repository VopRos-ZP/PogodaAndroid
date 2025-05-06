package ru.pogoda.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("info")
    val info: InfoBlock,
    val fact: FactBlock,
    @SerialName("forecast_24")
    val forecast24: Map<String, ForecastDay>,
    @SerialName("forecast_6")
    val forecast6: Map<String, ForecastDay>,
    @SerialName("forecast_3")
    val forecast3: ForecastHourly
)