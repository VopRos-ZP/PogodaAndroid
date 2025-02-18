package ru.pogoda.domain.model

data class Fact(
    val obsTime: String,
    val dist: Double,
    val condition: String,
    val conditionS: String,
    val temp: Double,
    val feelsLike: Double,
    val comfIdx: Int,
    val tempWater: Double,
    val humidity: Int,
    val pressure: Int,
    val windSpeedAvg: Double,
    val windDir: String,
    val light: String,
    val uvi: Int
)
