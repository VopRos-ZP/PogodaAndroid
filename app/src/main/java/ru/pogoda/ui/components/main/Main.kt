package ru.pogoda.ui.components.main

import com.arkivanov.decompose.ComponentContext
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf
import ru.pogoda.data.model.WeatherResponse
import ru.pogoda.domain.model.Fact

object Main {

    data class State(
        val weather: WeatherResponse? = null,
        val fact: Fact? = null
    )

    sealed interface Intent {
        data object OnSettingsClick : Intent
        data object OnFavoritesClick : Intent
        data object OnDailyClick : Intent
    }

    sealed interface Label {
        data object OnSettingsClick : Label
        data object OnFavoritesClick : Label
        data object OnDailyClick : Label
    }

    sealed interface Action {
        data class OnFactChange(val value: Fact) : Action
        data class OnWeatherChange(val fact: WeatherResponse) : Action
    }

    sealed interface Msg {
        data class OnFactChange(val value: Fact) : Msg
        data class OnWeatherChange(val fact: WeatherResponse) : Msg
    }

    fun params(
        context: ComponentContext,
        onSettings: () -> Unit,
        onFavorites: () -> Unit,
        onDailyClick: () -> Unit,
    ): ParametersDefinition = {
        parametersOf(
            context,
            onSettings,
            onFavorites,
            onDailyClick,
        )
    }

}