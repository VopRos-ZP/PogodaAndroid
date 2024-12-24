package ru.pogoda.ui.components.onboarding.geo

import ru.pogoda.ui.decompose.context.AppComponentContext

class DefaultGeoOnboardingComponent(
    context: AppComponentContext,
    private val onPermission: () -> Unit,
    private val onCustomize: () -> Unit,
) : GeoOnboardingComponent, AppComponentContext by context {

    override fun onPermissionClick() {
        onPermission()
    }

    override fun onCustomizeClick() {
        onCustomize()
    }

}