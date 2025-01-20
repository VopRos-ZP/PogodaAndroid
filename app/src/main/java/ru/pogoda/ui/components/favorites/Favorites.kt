package ru.pogoda.ui.components.favorites

import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf
import ru.pogoda.data.model.WeatherResponse
import ru.pogoda.ui.decompose.context.AppComponentContext

object Favorites {

    data class State(
        val search: String = "",
        val currentLocation: WeatherResponse = WeatherResponse()
    )

    sealed interface Intent {
        data class OnSearchChange(val value: String) : Intent

    }

    sealed interface Label {

    }

    sealed interface Action {

    }

    sealed interface Msg {
        data class OnSearchChange(val value: String) : Msg
    }

    fun params(
        context: AppComponentContext,
        onBackClick: () -> Unit,
    ): ParametersDefinition = {
        parametersOf(
            context,
            onBackClick,
        )
    }

}