package ru.pogoda.data.model

import kotlinx.serialization.Serializable

@Serializable
data class LocalizedName(
    val ru: String? = null,
    val en: String? = null
)