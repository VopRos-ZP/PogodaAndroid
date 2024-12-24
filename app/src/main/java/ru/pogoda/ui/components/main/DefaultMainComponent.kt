package ru.pogoda.ui.components.main

import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import ru.pogoda.ui.decompose.context.AppComponentContext

class DefaultMainComponent(
    context: AppComponentContext,
    private val storeFactory: MainStoreFactory,
) : MainComponent, AppComponentContext by context {

    private val store = instanceKeeper.getStore { storeFactory.create() }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val state = store.stateFlow

    override fun onFavoritesClick() {
        TODO("Not yet implemented")
    }

    override fun onSettingsClick() {
        TODO("Not yet implemented")
    }

    override fun onFiftyPogodaClick() {
        TODO("Not yet implemented")
    }

}