package ru.pogoda.ui.components.favorites

import com.arkivanov.decompose.ComponentContext
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf
import ru.pogoda.data.model.WeatherResponse

object Favorites {

    data class State(
        val search: String = "",
        val currentLocation: WeatherResponse? = null
    )

    sealed interface Intent {
        data object OnBackClick : Intent
        data class OnSearchChange(val value: String) : Intent
    }

    sealed interface Label {
        data object OnBackClick : Label
    }

    sealed interface Action

    sealed interface Msg {
        data class OnSearchChange(val value: String) : Msg
    }

    fun params(
        context: ComponentContext,
        onBackClick: () -> Unit,
    ): ParametersDefinition = {
        parametersOf(
            context,
            onBackClick,
        )
    }

}