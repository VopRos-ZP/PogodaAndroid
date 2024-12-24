package ru.pogoda.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ForecastDetails(
    val light: String? = null,
    val condition: String? = null,
    val condition_s: String? = null,
    val temp_min: Double? = null,
    val temp_max: Double? = null,
    val temp: Double? = null,
    val humidity: Int? = null,
    val prec_prob: Int? = null,
    val wind_gust: Double? = null,
    val wind_speed: Double? = null,
    val wind_dir: String? = null,
    val pressure: Int? = null,
    val uvi: Int? = null,
    val feels_like: Double? = null,
    val comf_idx: Int? = null
)
