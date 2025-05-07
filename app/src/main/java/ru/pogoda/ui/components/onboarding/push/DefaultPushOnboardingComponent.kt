package ru.pogoda.ui.components.onboarding.push

import com.arkivanov.decompose.ComponentContext

class DefaultPushOnboardingComponent(
    context: ComponentContext,
    private val onPermission: () -> Unit
) : PushOnboardingComponent, ComponentContext by context {

    override fun onPermissionClick() {
        onPermission()
    }

    override fun onNotNowClick() {
        // Nothing
    }

}