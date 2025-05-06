package ru.pogoda.ui.components.city_selection

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory

class CitySelectionStoreFactory(
    private val storeFactory: StoreFactory
) {

    fun create(): CitySelectionStore = object : CitySelectionStore,
        Store<CitySelection.Intent, CitySelection.State, CitySelection.Label> by storeFactory.create<CitySelection.Intent, CitySelection.Action, CitySelection.Msg, CitySelection.State, CitySelection.Label>(
            name = "CitySelectionStore",
            initialState = CitySelection.State(),
            executorFactory = coroutineExecutorFactory {
                onIntent<CitySelection.Intent.OnBackClick> {
                    publish(CitySelection.Label.OnBackClick)
                }
                onIntent<CitySelection.Intent.OnCitySelected> {
                    publish(CitySelection.Label.OnCitySelected(it.value))
                }
                onIntent<CitySelection.Intent.OnSearchChange> {
                    dispatch(CitySelection.Msg.OnSearchChange(it.text))
                }
            },
            reducer = {
                when (it) {
                    is CitySelection.Msg.OnSearchChange -> copy(search = it.text)
                }
            }
        ) {}

}