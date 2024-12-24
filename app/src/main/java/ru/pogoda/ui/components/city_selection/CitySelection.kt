package ru.pogoda.ui.components.city_selection

import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf
import ru.pogoda.ui.decompose.context.AppComponentContext

object CitySelection {

    data class State(
        val search: String = "",
    )

    sealed interface Intent {
        data class OnSearchChange(val text: String) : Intent
    }

    sealed interface Label

    sealed interface Action

    sealed interface Msg {
        data class OnSearchChange(val text: String) : Msg
    }

    fun params(
        context: AppComponentContext,
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