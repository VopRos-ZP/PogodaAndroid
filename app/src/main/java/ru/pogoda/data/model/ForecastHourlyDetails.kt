package ru.pogoda.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastHourlyDetails(
    val date: String,
    val light: String,
    val condition: String,
    @SerialName("condition_s")
    val conditionS: String,
    @SerialName("temp_min")
    val tempMin: Double,
    @SerialName("temp_max")
    val tempMax: Double,
    val temp: Double,
    val humidity: Int,
    @SerialName("prec_prob")
    val precProb: Int,
    @SerialName("wind_gust")
    val windGust: Double,
    @SerialName("wind_speed")
    val windSpeed: Double,
    @SerialName("wind_dir")
    val windDir: String,
    val pressure: Int,
    val uvi: Int,
    @SerialName("feels_like")
    val feelsLike: Double,
    @SerialName("comf_idx")
    val comfIdx: Int
)
