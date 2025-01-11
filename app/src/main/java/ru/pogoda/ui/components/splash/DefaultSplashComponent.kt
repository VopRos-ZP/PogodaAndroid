package ru.pogoda.ui.components.splash

import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import kotlinx.coroutines.launch
import ru.pogoda.ui.decompose.context.AppComponentContext

class DefaultSplashComponent(
    componentContext: AppComponentContext,
    private val onOnboarding: () -> Unit,
    private val onMain: () -> Unit,
    private val storeFactory: SplashStoreFactory,
) : SplashComponent, AppComponentContext by componentContext {

    private val store = instanceKeeper.getStore { storeFactory.create() }

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
