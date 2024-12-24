package ru.pogoda.ui.components.city_selection

import kotlinx.coroutines.flow.StateFlow

interface CitySelectionComponent {
    val state: StateFlow<CitySelection.State>

    fun onBackClick()
    fun onSearchChange(text: String)
    fun onCitySelected(city: String)
}