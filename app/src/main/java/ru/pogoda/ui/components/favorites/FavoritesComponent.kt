package ru.pogoda.ui.components.favorites

import kotlinx.coroutines.flow.StateFlow

interface FavoritesComponent {

    val state: StateFlow<Favorites.State>

    fun onBackClick()
    fun onSearchChange(value: String)

}