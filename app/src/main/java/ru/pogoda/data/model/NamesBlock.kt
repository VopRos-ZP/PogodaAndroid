package ru.pogoda.data.model

import kotlinx.serialization.Serializable

@Serializable
data class NamesBlock(
    val name: LocalizedName,
    val admin: LocalizedName,
    val island: LocalizedName? = null,
)