package ru.pogoda.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ForecastHourly(
    val start_date: String,
    val `0`: ForecastHourlyDetails? = null
)
