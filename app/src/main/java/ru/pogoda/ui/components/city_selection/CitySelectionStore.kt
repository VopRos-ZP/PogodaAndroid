package ru.pogoda.ui.components.city_selection

import com.arkivanov.mvikotlin.core.store.Store

interface CitySelectionStore : Store<CitySelection.Intent, CitySelection.State, CitySelection.Label>