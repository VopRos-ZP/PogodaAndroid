package ru.pogoda.ui.components.settings

import com.arkivanov.decompose.ComponentContext
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf

object Settings {

    data class State(
        val temp: Int = 0,
        val wind: Int = 0,
        val pressure: Int = 0,
        val time: Int = 0,
        val version: String = "",
    )

    sealed interface Intent {
        data object OnBackClick : Intent
        data class OnTempChange(val value: Int) : Intent
        data class OnWindChange(val value: Int) : Intent
        data class OnPressureChange(val value: Int) : Intent
        data class OnTimeChange(val value: Int) : Intent
    }

    sealed interface Label {
        data object OnBackClick : Label
    }

    sealed interface Action {
        data class OnVersionChange(val value: String) : Action
    }

    sealed interface Msg {
        data class OnTempChange(val value: Int) : Msg
        data class OnWindChange(val value: Int) : Msg
        data class OnPressureChange(val value: Int) : Msg
        data class OnTimeChange(val value: Int) : Msg
        data class OnVersionChange(val value: String) : Msg
    }

    fun params(
        context: ComponentContext,
        onBack: () -> Unit,
        onIcon: () -> Unit,
        onTheme: () -> Unit,
        onPolitics: () -> Unit,
        onConditionUse: () -> Unit,
        onLocation: () -> Unit,
    ): ParametersDefinition = {
        parametersOf(
            context,
            onBack,
            onIcon,
            onTheme,
            onPolitics,
            onConditionUse,
            onLocation,
        )
    }

}