package ru.pogoda.ui.components.favorites

import kotlinx.coroutines.flow.StateFlow
import ru.pogoda.ui.decompose.context.AppComponentContext

class DefaultFavoritesComponent(
    context: AppComponentContext,
) : FavoritesComponent, AppComponentContext by context {

    override val state: StateFlow<Favorites.State>
        get() = TODO("Not yet implemented")

    override fun onBackClick() {
        TODO("Not yet implemented")
    }

    override fun onSearchChange(value: String) {
        TODO("Not yet implemented")
    }
}