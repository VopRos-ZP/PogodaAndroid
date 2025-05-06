package ru.pogoda.ui.components.main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import ru.pogoda.ui.extensions.componentScope

@OptIn(ExperimentalCoroutinesApi::class)
class DefaultMainComponent(
    context: ComponentContext,
    private val onSettings: () -> Unit,
    private val onFavorites: () -> Unit,
    private val onDaily: () -> Unit,
    private val storeFactory: MainStoreFactory,
) : MainComponent, ComponentContext by context {

    private val store = instanceKeeper.getStore { storeFactory.create() }
    private val scope = componentScope()

    override val state = store.stateFlow

    init {
        scope.launch {
            store.labels.collect {
                when (it) {
                    is Main.Label.OnDailyClick -> onDaily()
                    is Main.Label.OnSettingsClick -> onSettings()
                    is Main.Label.OnFavoritesClick -> onFavorites()
                }
            }
        }
    }

    override fun onFavoritesClick() {
        store.accept(Main.Intent.OnFavoritesClick)
    }

    override fun onSettingsClick() {
        store.accept(Main.Intent.OnSettingsClick)
    }

    override fun onDailyClick() {
        store.accept(Main.Intent.OnDailyClick)
    }

}