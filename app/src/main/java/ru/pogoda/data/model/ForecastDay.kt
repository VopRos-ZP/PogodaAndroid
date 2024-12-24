package ru.pogoda.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ForecastDay(
    val sunrise: String? = null,
    val sunset: String? = null,
    val moonrise: String? = null,
    val moonset: String? = null,
    val moon_phase: Int? = null,
    val start_date: String? = null,
    val day: ForecastDetails? = null,
    val night: ForecastDetails? = null
)