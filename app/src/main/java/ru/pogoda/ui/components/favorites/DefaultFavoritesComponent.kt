package ru.pogoda.ui.components.favorites

import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import ru.pogoda.ui.decompose.context.AppComponentContext

@OptIn(ExperimentalCoroutinesApi::class)
class DefaultFavoritesComponent(
    context: AppComponentContext,
    private val onBack: () -> Unit,
    private val storeFactory: FavoritesStoreFactory,
) : FavoritesComponent, AppComponentContext by context {

    private val store = instanceKeeper.getStore { storeFactory.create() }

    override val state = store.stateFlow

    override fun onBackClick() {
        onBack()
    }

    override fun onSearchChange(value: String) {
        store.accept(Favorites.Intent.OnSearchChange(value))
    }
}