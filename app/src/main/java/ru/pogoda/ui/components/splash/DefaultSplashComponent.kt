package ru.pogoda.ui.components.splash

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import kotlinx.coroutines.launch
import ru.pogoda.ui.extensions.componentScope

class DefaultSplashComponent(
    context: ComponentContext,
    private val onOnboarding: () -> Unit,
    private val onMain: () -> Unit,
    private val storeFactory: SplashStoreFactory,
) : SplashComponent, ComponentContext by context {

    private val store = instanceKeeper.getStore { storeFactory.create() }
    private val scope = componentScope()

    init {
        scope.launch {
            store.labels.collect {
                when (it) {
                    is Splash.Label.OnGetPermission -> {
                        when (it.isGranted) {
                            true -> onMain()
                            else -> onOnboarding()
                        }
                    }
                }
            }
        }
    }

    override fun checkPermissions() {
        store.accept(Splash.Intent.CheckPermissions)
    }

}
