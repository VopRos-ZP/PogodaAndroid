package ru.pogoda.ui.components.onboarding.geo

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import kotlinx.coroutines.launch
import ru.pogoda.ui.extensions.componentScope

class DefaultGeoOnboardingComponent(
    private val storeFactory: GeoOnboardingStoreFactory,
    private val onPermission: () -> Unit,
    private val onCustomize: () -> Unit,
    context: ComponentContext,
) : GeoOnboardingComponent, ComponentContext by context {

    private val store = instanceKeeper.getStore { storeFactory.create() }
    private val scope = componentScope()

    init {
        scope.launch {
            store.labels.collect {
                when (it) {
                    is GeoOnboarding.Label.OnPermissionClick -> onPermission()
                    is GeoOnboarding.Label.OnCustomizeClick -> onCustomize()
                }
            }
        }
    }

    override fun onPermissionClick() {
        store.accept(GeoOnboarding.Intent.OnPermissionClick)
    }

    override fun onCustomizeClick() {
        store.accept(GeoOnboarding.Intent.OnCustomizeClick)
    }

}