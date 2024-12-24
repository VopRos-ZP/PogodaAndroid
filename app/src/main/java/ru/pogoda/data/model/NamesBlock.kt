package ru.pogoda.data.model

import kotlinx.serialization.Serializable

@Serializable
data class NamesBlock(
    val name: LocalizedName? = null,
    val admin: LocalizedName? = null,
    val island: LocalizedName? = null
)