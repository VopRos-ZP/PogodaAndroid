package ru.pogoda.ui.components.onboarding.push

import com.arkivanov.decompose.ComponentContext
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf

object PushOnboarding {

    fun params(
        context: ComponentContext,
        onPermissionGrated: () -> Unit
    ): ParametersDefinition = {
        parametersOf(
            context,
            onPermissionGrated
        )
    }

}