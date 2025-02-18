package ru.pogoda.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastHourly(
    @SerialName("start_date")
    val startDate: String,
    @SerialName("0")
    val forecastHourlyDetails: ForecastHourlyDetails
)
