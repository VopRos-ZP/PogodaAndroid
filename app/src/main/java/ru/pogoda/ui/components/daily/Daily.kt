package ru.pogoda.ui.components.daily

import com.arkivanov.decompose.ComponentContext
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf
import ru.pogoda.data.model.WeatherResponse

object Daily {

    data class State(
        val weatherResponse: WeatherResponse? = null,
    )

    sealed interface Intent {
        data object OnBackClick : Intent
    }

    sealed interface Label {
        data object OnBackClick : Label
    }

    sealed interface Action

    sealed interface Msg

    fun params(
        context: ComponentContext,
        onBackClick: () -> Unit,
    ): ParametersDefinition = {
        parametersOf(
            context,
            onBackClick
        )
    }

}