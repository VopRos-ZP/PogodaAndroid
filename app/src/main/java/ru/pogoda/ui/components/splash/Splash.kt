package ru.pogoda.ui.components.splash

import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf
import ru.pogoda.ui.decompose.context.AppComponentContext

object Splash {

    class State

    sealed interface Intent {
        data object CheckPermissions : Intent
    }

    sealed interface Label {
        data class OnGetPermission(val isGranted: Boolean) : Label
    }

    fun params(
        context: AppComponentContext,
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