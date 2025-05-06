package ru.pogoda.ui.components.onboarding.geo

import androidx.room.util.copy
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.core.store.create
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory
import ru.pogoda.ui.components.onboarding.geo.GeoOnboarding.State
import ru.pogoda.ui.components.onboarding.geo.GeoOnboarding.Intent
import ru.pogoda.ui.components.onboarding.geo.GeoOnboarding.Label
import ru.pogoda.ui.components.onboarding.geo.GeoOnboarding.Action
import ru.pogoda.ui.components.onboarding.geo.GeoOnboarding.Msg

class GeoOnboardingStoreFactory(
    private val storeFactory: StoreFactory
) {

    fun create(): GeoOnboardingStore = object : GeoOnboardingStore, Store<Intent, State, Label> by storeFactory.create<Intent, Action, Msg, State, Label>(
        name = "GeoOnboardingStore",
        initialState = State(),
        bootstrapper = coroutineBootstrapper {

        },
        executorFactory = coroutineExecutorFactory {
            onIntent<Intent.OnPermissionClick> {
                publish(Label.OnPermissionClick)
            }
            onIntent<Intent.OnCustomizeClick> {
                publish(Label.OnCustomizeClick)
            }
        },
        reducer = { this }
    ) {}

}