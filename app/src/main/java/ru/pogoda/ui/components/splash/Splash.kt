package ru.pogoda.ui.components.splash

import com.arkivanov.decompose.ComponentContext
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf

object Splash {

    class State

    sealed interface Intent {
        data object CheckPermissions : Intent
    }

    sealed interface Label {
        data class OnGetPermission(val isGranted: Boolean) : Label
    }

    fun params(
        context: ComponentContext,
        onOnboarding: () -> Unit,
        onMain: () -> Unit,
    ): ParametersDefinition = {
        parametersOf(
            context,
            onOnboarding,
            onMain
        )
    }

}