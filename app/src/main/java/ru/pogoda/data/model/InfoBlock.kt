package ru.pogoda.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfoBlock(
    val cache: CacheInfo,
    @SerialName("local_date")
    val localDate: String,
    val lat: Double,
    val lon: Double,
    val dist: Double,
    val elevation: Double,
    val names: NamesBlock,
    val country: String
)