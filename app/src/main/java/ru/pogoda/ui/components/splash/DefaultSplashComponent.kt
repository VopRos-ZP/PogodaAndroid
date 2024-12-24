package ru.pogoda.ui.components.splash

import ru.pogoda.ui.decompose.context.AppComponentContext

class DefaultSplashComponent(
    componentContext: AppComponentContext,
    private val onOnboarding: () -> Unit,
) : SplashComponent, AppComponentContext by componentContext {

    override fun onLoadingSuccess() {
        onOnboarding()
    }

}