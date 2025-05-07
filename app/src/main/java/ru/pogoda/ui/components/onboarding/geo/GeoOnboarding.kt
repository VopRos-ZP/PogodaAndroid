package ru.pogoda.ui.components.onboarding.geo

import com.arkivanov.decompose.ComponentContext
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf

object GeoOnboarding {

    class State

    sealed interface Intent {
        data object OnPermissionClick : Intent
        data object OnCustomizeClick : Intent
    }

    sealed interface Label {
        data object OnPermissionClick : Label
        data object OnCustomizeClick : Label
    }

    sealed interface Action

    sealed interface Msg

    fun params(
        onPermissionGrated: () -> Unit,
        onCustomizeClick: () -> Unit,
        context: ComponentContext
    ): ParametersDefinition = {
        parametersOf(
            onPermissionGrated,
            onCustomizeClick,
            context
        )
    }

}