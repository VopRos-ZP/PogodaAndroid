package ru.pogoda.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CacheInfo(
    val id: String,
    @SerialName("f_date")
    val fDate: String
)