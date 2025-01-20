package ru.pogoda.ui.components.daily

import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf
import ru.pogoda.data.model.WeatherResponse
import ru.pogoda.ui.decompose.context.AppComponentContext

object Daily {

    data class State(
        val weatherResponse: WeatherResponse? = null,
    )

    sealed interface Intent

    sealed interface Action {

    }

    sealed interface Label

    sealed interface Msg {

    }

    fun params(
        context: AppComponentContext,
        onBackClick: () -> Unit,
    ): ParametersDefinition = {
        parametersOf(
            context,
            onBackClick
        )
    }

}