package ru.pogoda.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FactBlock(
    @SerialName("obs_time")
    val obsTime: String,
    val dist: Double,
    val condition: String,
    @SerialName("condition_s")
    val conditionS: String,
    val temp: Double,
    @SerialName("feels_like")
    val feelsLike: Double,
    @SerialName("comf_idx")
    val comfIdx: Int,
    @SerialName("temp_water")
    val tempWater: Double,
    val humidity: Int,
    val pressure: Int,
    @SerialName("wind_speed_avg")
    val windSpeedAvg: Double,
    @SerialName("wind_dir")
    val windDir: String,
    val light: String,
    val uvi: Int
)
