package ru.pogoda.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FactBlock(
    @SerialName("obs_time")
    val obsTime: String,
    @SerialName("dist")
    val dist: Double,
    @SerialName("condition")
    val condition: String,
    @SerialName("condition_s")
    val conditionS: String,
    @SerialName("temp")
    val temp: Double,
    @SerialName("feels_like")
    val feelsLike: Double,
    @SerialName("comf_idx")
    val comfIdx: Int,
    @SerialName("temp_water")
    val tempWater: Double,
    @SerialName("humidity")
    val humidity: Int,
    @SerialName("pressure")
    val pressure: Int,
    @SerialName("wind_speed_avg")
    val windSpeedAvg: Double,
    @SerialName("wind_dir")
    val windDir: String,
    @SerialName("light")
    val light: String,
    @SerialName("uvi")
    val uvi: Int
)
