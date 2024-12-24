package ru.pogoda.ui.components.settings

object Settings {

    data class State(
        val temp: Int,
        val wind: Int,
        val pressure: Int,
        val time: Int,
        val version: String,
    )

}