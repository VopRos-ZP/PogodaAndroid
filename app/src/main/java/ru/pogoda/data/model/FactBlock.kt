package ru.pogoda.data.model

import kotlinx.serialization.Serializable

@Serializable
data class FactBlock(
    val obs_time: String? = null,
    val dist: Double? = null,
    val condition: String? = null,
    val condition_s: String? = null,
    val temp: Double? = null,
    val feels_like: Double? = null,
    val comf_idx: Int? = null,
    val temp_water: Double? = null,
    val humidity: Int? = null,
    val pressure: Int? = null,
    val wind_speed_avg: Double? = null,
    val wind_dir: String? = null,
    val light: String? = null,
    val uvi: Int? = null
)
