package ru.pogoda.ui.components.favorites

import com.arkivanov.mvikotlin.core.store.Store

interface FavoritesStore : Store<Favorites.Intent ,Favorites.State, Favorites.Label>