package ru.pogoda.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CacheInfo(
    val id: String,
    val f_date: String
)