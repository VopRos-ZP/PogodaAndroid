package ru.pogoda.ui.components.main

import kotlinx.coroutines.flow.StateFlow

interface MainComponent {
    val state: StateFlow<Main.State>

    fun onFavoritesClick()
    fun onSettingsClick()
    fun onFiftyPogodaClick()
}