package ru.pogoda.ui.components.splash

import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf
import ru.pogoda.ui.decompose.context.AppComponentContext

object Splash {

    fun params(
        context: AppComponentContext,
        onOnboarding: () -> Unit
    ): ParametersDefinition = {
        parametersOf(
            context,
            onOnboarding
        )
    }

}