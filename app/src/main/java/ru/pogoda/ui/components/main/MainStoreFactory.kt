package ru.pogoda.ui.components.main

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory
import kotlinx.coroutines.launch
import ru.pogoda.domain.repository.LocationRepository
import ru.pogoda.domain.repository.WeatherRepository

class MainStoreFactory(
    private val storeFactory: StoreFactory,
    private val weatherRepository: WeatherRepository,
    private val locationRepository: LocationRepository,
) {

    fun create(): MainStore =
        object : MainStore, Store<Main.Intent, Main.State, Main.Label> by storeFactory.create<Main.Intent, Main.Action, Main.Msg, Main.State, Main.Label>(
            name = "MainStore",
            initialState = Main.State(),
            bootstrapper = coroutineBootstrapper {
                launch {
                    locationRepository.currentLocation.collect { (lat, lon) ->
                        dispatch(Main.Action.OnFactChange(
                            weatherRepository.fetchFact(
                                lat = lat,
                                lon = lon,
                                type = "1",
                                period = "1",
                                mode = "city",
                                block = "fact"
                            )
                        ))
                    }
                }
            },
            executorFactory = coroutineExecutorFactory {
                onIntent<Main.Intent.OnDailyClick> {
                    publish(Main.Label.OnDailyClick)
                }
                onIntent<Main.Intent.OnSettingsClick> {
                    publish(Main.Label.OnSettingsClick)
                }
                onIntent<Main.Intent.OnFavoritesClick> {
                    publish(Main.Label.OnFavoritesClick)
                }
                onAction<Main.Action.OnWeatherChange> {
                    dispatch(Main.Msg.OnWeatherChange(it.fact))
                }
                onAction<Main.Action.OnFactChange> {
                    dispatch(Main.Msg.OnFactChange(it.value))
                }
            },
            reducer = {
                when (it) {
                    is Main.Msg.OnFactChange -> copy(fact = it.value)
                    is Main.Msg.OnWeatherChange -> copy(weather = it.fact)
                }
            }
        ) {}

}