package ru.pogoda.ui.components.onboarding.push

import ru.pogoda.ui.decompose.context.AppComponentContext

class DefaultPushOnboardingComponent(
    context: AppComponentContext,
    private val onPermission: () -> Unit
) : PushOnboardingComponent, AppComponentContext by context {

    override fun onPermissionClick() {
        onPermission()
    }

    override fun onNotNowClick() {
        // Nothing
    }

}