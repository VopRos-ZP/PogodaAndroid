package ru.pogoda.ui.decompose.context

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ComponentContextFactory
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import com.arkivanov.essenty.instancekeeper.InstanceKeeperOwner
import com.arkivanov.essenty.lifecycle.LifecycleOwner
import com.arkivanov.essenty.lifecycle.doOnDestroy
import com.arkivanov.essenty.statekeeper.StateKeeperOwner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel

class DefaultAppComponentContext(
    componentContext: ComponentContext,
    override val scope: CoroutineScope,
) : AppComponentContext,
    LifecycleOwner by componentContext,
    StateKeeperOwner by componentContext,
    InstanceKeeperOwner by componentContext,
    BackHandlerOwner by componentContext {

    override val componentContextFactory =
        ComponentContextFactory { lifecycle, stateKeeper, instanceKeeper, backHandler ->
            DefaultAppComponentContext(
                componentContext = componentContext.componentContextFactory(
                    lifecycle = lifecycle,
                    stateKeeper = stateKeeper,
                    instanceKeeper = instanceKeeper,
                    backHandler = backHandler
                ),
                scope = scope.apply {
                    lifecycle.doOnDestroy {
                        cancel()
                    }
                }
            )
        }
}