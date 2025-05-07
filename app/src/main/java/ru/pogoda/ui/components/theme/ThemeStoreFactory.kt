package ru.pogoda.ui.components.theme

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory
import ru.pogoda.ui.components.theme.Theme.Action
import ru.pogoda.ui.components.theme.Theme.Intent
import ru.pogoda.ui.components.theme.Theme.Label
import ru.pogoda.ui.components.theme.Theme.Msg
import ru.pogoda.ui.components.theme.Theme.State

class ThemeStoreFactory(
    private val storeFactory: StoreFactory,
) {

    fun create(): ThemeStore =
        object : ThemeStore, Store<Intent, State, Label> by storeFactory.create<Intent, Action, Msg, State, Label>(
            name = "ThemeStore",
            initialState = State(),
            bootstrapper = coroutineBootstrapper {

            },
            executorFactory = coroutineExecutorFactory {
                onIntent<Intent.OnBackClick> {
                    publish(Label.OnBackClick)
                }
                onIntent<Intent.OnThemeChange> {
                    dispatch(Msg.OnThemeChange(it.value))
                }
                onIntent<Intent.OnLogoChange> {
                    dispatch(Msg.OnLogoChange(it.value))
                }
            },
            reducer = {
                when (it) {
                    is Msg.OnThemeChange -> copy(theme = it.value)
                    is Msg.OnLogoChange -> copy(logo = it.value)
                }
            }
        ) {}

}