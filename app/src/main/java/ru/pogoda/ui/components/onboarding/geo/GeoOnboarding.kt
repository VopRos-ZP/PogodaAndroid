package ru.pogoda.ui.components.onboarding.geo

import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf
import ru.pogoda.ui.decompose.context.AppComponentContext

object GeoOnboarding {

    fun params(
        context: AppComponentContext,
        onPermissionGrated: () -> Unit,
        onCustomizeClick: () -> Unit
    ): ParametersDefinition = {
        parametersOf(
            context,
            onPermissionGrated,
            onCustomizeClick
        )
    }

}