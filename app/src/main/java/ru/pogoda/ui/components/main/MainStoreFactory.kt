package ru.pogoda.ui.components.main

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory
import kotlinx.coroutines.launch
import ru.pogoda.domain.repository.WeatherRepository

class MainStoreFactory(
    private val storeFactory: StoreFactory,
    private val weatherRepository: WeatherRepository
) {

    fun create(): MainStore =
        object : MainStore, Store<Main.Intent, Main.State, Main.Label> by storeFactory.create<Main.Intent, Main.Action, Main.Msg, Main.State, Main.Label>(
            name = "MainStore",
            initialState = Main.State(),
            bootstrapper = coroutineBootstrapper {
                launch {
                    weatherRepository.weather.collect {
                        dispatch(Main.Action.OnWeatherChange(it))
                    }
                }
            },
            executorFactory = coroutineExecutorFactory {
                onAction<Main.Action.OnWeatherChange> {
                    dispatch(Main.Msg.OnWeatherChange(it.fact))
                }
            },
            reducer = {
                when (it) {
                    is Main.Msg.OnWeatherChange -> copy(weather = it.fact)
                }
            }
        ) {}

}