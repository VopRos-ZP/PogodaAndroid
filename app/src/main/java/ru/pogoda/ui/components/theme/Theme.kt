package ru.pogoda.ui.components.theme

import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf
import ru.pogoda.ui.decompose.context.AppComponentContext

object Theme {

    const val LIGHT = 0
    const val DARK = 1
    const val SYSTEM = 2

    const val YELLOW = 0
    const val BLUE = 1

    data class State(
        val theme: Int = SYSTEM,
        val logo: Int = YELLOW,
    )

    sealed interface Intent {
        data class OnThemeChange(val value: Int) : Intent
        data class OnLogoChange(val value: Int) : Intent
    }

    sealed interface Label

    sealed interface Action {
        data class OnThemeChange(val value: Int) : Action
    }

    sealed interface Msg {
        data class OnThemeChange(val value: Int) : Msg
        data class OnLogoChange(val value: Int) : Msg
    }

    fun params(
        context: AppComponentContext,
        onBackClick: () -> Unit,
    ) : ParametersDefinition = {
        parametersOf(
            context,
            onBackClick
        )
    }

}