package ru.pogoda.ui.components.favorites

import ru.pogoda.data.model.WeatherResponse

object Favorites {

    data class State(
        val search: String = "",
        val currentLocation: WeatherResponse = WeatherResponse(),

        )

    sealed interface Intent {
        data class OnSearchChange(val value: String) : Intent

    }

}