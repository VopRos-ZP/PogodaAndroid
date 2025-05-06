package ru.pogoda.ui.components.favorites

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import ru.pogoda.ui.extensions.componentScope

@OptIn(ExperimentalCoroutinesApi::class)
class DefaultFavoritesComponent(
    context: ComponentContext,
    private val onBack: () -> Unit,
    private val storeFactory: FavoritesStoreFactory,
) : FavoritesComponent, ComponentContext by context {

    private val store = instanceKeeper.getStore { storeFactory.create() }
    private val scope = componentScope()

    override val state = store.stateFlow

    init {
        scope.launch {
            store.labels.collect {
                when (it) {
                    is Favorites.Label.OnBackClick -> onBack()
                }
            }
        }
    }

    override fun onBackClick() {
        store.accept(Favorites.Intent.OnBackClick)
    }

    override fun onSearchChange(value: String) {
        store.accept(Favorites.Intent.OnSearchChange(value))
    }

}