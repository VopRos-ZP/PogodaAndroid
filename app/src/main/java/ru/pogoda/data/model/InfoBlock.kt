package ru.pogoda.data.model

import kotlinx.serialization.Serializable

@Serializable
data class InfoBlock(
    val cache: CacheInfo? = null,
    val local_date: String? = null,
    val lat: Double? = null,
    val lon: Double? = null,
    val dist: Double? = null,
    val elevation: Double? = null,
    val names: NamesBlock? = null,
    val country: String? = null
)