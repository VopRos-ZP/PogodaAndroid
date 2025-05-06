package ru.pogoda.ui.components.favorites

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory
import ru.pogoda.ui.components.favorites.Favorites.Intent
import ru.pogoda.ui.components.favorites.Favorites.State
import ru.pogoda.ui.components.favorites.Favorites.Label
import ru.pogoda.ui.components.favorites.Favorites.Action
import ru.pogoda.ui.components.favorites.Favorites.Msg

class FavoritesStoreFactory(
    private val storeFactory: StoreFactory
) {

    fun create(): FavoritesStore = object : FavoritesStore,
        Store<Intent, State, Label> by storeFactory.create<Intent, Action, Msg, State, Label>(
            name = "FavoritesStore",
            initialState = State(),
            executorFactory = coroutineExecutorFactory {
                onIntent<Intent.OnBackClick> {
                    publish(Label.OnBackClick)
                }
                onIntent<Intent.OnSearchChange> {
                    dispatch(Msg.OnSearchChange(it.value))
                }
            },
            reducer = {
                when (it) {
                    is Msg.OnSearchChange -> copy(search = it.value)
                }
            }
        ) {}

}