package ru.pogoda.ui.components.city_selection

import com.arkivanov.decompose.ComponentContext
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf

object CitySelection {

    data class State(
        val search: String = "",
    )

    sealed interface Intent {
        data object OnBackClick : Intent
        data class OnCitySelected(val value: String) : Intent
        data class OnSearchChange(val text: String) : Intent
    }

    sealed interface Label {
        data object OnBackClick : Label
        data class OnCitySelected(val value: String) : Label
    }

    sealed interface Action

    sealed interface Msg {
        data class OnSearchChange(val text: String) : Msg
    }

    fun params(
        context: ComponentContext,
        onBackClick: () -> Unit,
        onCitySelected: (String) -> Unit,
    ): ParametersDefinition = {
        parametersOf(
            context,
            onBackClick,
            onCitySelected
        )
    }

}