package ru.pogoda.domain.model

data class ForecastDetails(
    val light: String,
    val condition: String,
    val conditionS: String,
    val tempMin: Double,
    val tempMax: Double,
    val temp: Double,
    val humidity: Int,
    val precProb: Int,
    val windGust: Double,
    val windSpeed: Double,
    val windDir: String,
    val pressure: Int,
    val uvi: Int,
    val feelsLike: Double,
    val comfIdx: Int
)
