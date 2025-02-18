package ru.pogoda.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastDay(
    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moonset: String,
    @SerialName("moon_phase")
    val moonPhase: Int,
    @SerialName("start_date")
    val startDate: String,
    val day: ForecastDetails,
    val night: ForecastDetails
)