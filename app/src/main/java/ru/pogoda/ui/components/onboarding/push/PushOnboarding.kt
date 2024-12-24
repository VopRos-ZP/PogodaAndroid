package ru.pogoda.ui.components.onboarding.push

import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf
import ru.pogoda.ui.decompose.context.AppComponentContext

object PushOnboarding {

    fun params(
        context: AppComponentContext,
        onPermissionGrated: () -> Unit
    ): ParametersDefinition = {
        parametersOf(
            context,
            onPermissionGrated
        )
    }

}