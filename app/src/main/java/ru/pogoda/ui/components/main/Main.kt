package ru.pogoda.ui.components.main

import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf
import ru.pogoda.data.model.WeatherResponse
import ru.pogoda.ui.decompose.context.AppComponentContext

object Main {

    data class State(
        val fact: WeatherResponse = WeatherResponse(),
    )

    sealed interface Intent {

    }

    sealed interface Label

    sealed interface Action {
        data class OnWeatherChange(val fact: WeatherResponse) : Action
    }

    sealed interface Msg {
        data class OnWeatherChange(val fact: WeatherResponse) : Msg
    }

    fun params(
        context: AppComponentContext,
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