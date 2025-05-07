package ru.pogoda.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastHourly1(
    @SerialName("11")
    val `11`: ForecastHourlyDetails,
    @SerialName("12")
    val `12`: ForecastHourlyDetails,
    @SerialName("13")
    val `13`: ForecastHourlyDetails,
    @SerialName("14")
    val `14`: ForecastHourlyDetails,
    @SerialName("15")
    val `15`: ForecastHourlyDetails,
    @SerialName("16")
    val `16`: ForecastHourlyDetails,
    @SerialName("17")
    val `17`: ForecastHourlyDetails,
    @SerialName("18")
    val `18`: ForecastHourlyDetails,
    @SerialName("19")
    val `19`: ForecastHourlyDetails,
    @SerialName("20")
    val `20`: ForecastHourlyDetails,
    @SerialName("21")
    val `21`: ForecastHourlyDetails,
    @SerialName("22")
    val `22`: ForecastHourlyDetails,
    @SerialName("23")
    val `23`: ForecastHourlyDetails,
    @SerialName("24")
    val `24`: ForecastHourlyDetails,
    @SerialName("25")
    val `25`: ForecastHourlyDetails,
    @SerialName("26")
    val `26`: ForecastHourlyDetails,
    @SerialName("27")
    val `27`: ForecastHourlyDetails,
    @SerialName("28")
    val `28`: ForecastHourlyDetails,
    @SerialName("29")
    val `29`: ForecastHourlyDetails,
    @SerialName("30")
    val `30`: ForecastHourlyDetails,
    @SerialName("31")
    val `31`: ForecastHourlyDetails,
    @SerialName("32")
    val `32`: ForecastHourlyDetails,
    @SerialName("33")
    val `33`: ForecastHourlyDetails,
    @SerialName("34")
    val `34`: ForecastHourlyDetails,
    @SerialName("sunrise")
    val sunrise: String,
    @SerialName("sunset")
    val sunset: String,
    @SerialName("moonrise")
    val moonrise: String,
    @SerialName("moonset")
    val moonset: String,
    @SerialName("moon_phase")
    val moonPhase: Int,
)
