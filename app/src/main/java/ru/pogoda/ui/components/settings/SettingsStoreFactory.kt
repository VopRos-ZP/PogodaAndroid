package ru.pogoda.ui.components.settings

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory
import ru.pogoda.ui.components.settings.Settings.Action
import ru.pogoda.ui.components.settings.Settings.Intent
import ru.pogoda.ui.components.settings.Settings.Label
import ru.pogoda.ui.components.settings.Settings.Msg
import ru.pogoda.ui.components.settings.Settings.State


class SettingsStoreFactory(
    private val storeFactory: StoreFactory,
    private val context: Context,
) {

    fun create(): SettingsStore = object : SettingsStore,
        Store<Intent, State, Label> by storeFactory.create<Intent, Action, Msg, State, Label>(
            name = "SettingsStore",
            initialState = State(),
            bootstrapper = coroutineBootstrapper {
                val info = context.packageManager.getPackageInfo(context.packageName, 0)
                dispatch(Action.OnVersionChange(info.versionName ?: ""))
            },
            executorFactory = coroutineExecutorFactory {
                onIntent<Intent.OnBackClick> { publish(Label.OnBackClick) }

                onIntent<Intent.OnTempChange> { dispatch(Msg.OnTempChange(it.value)) }
                onIntent<Intent.OnWindChange> { dispatch(Msg.OnWindChange(it.value)) }
                onIntent<Intent.OnPressureChange> { dispatch(Msg.OnPressureChange(it.value)) }
                onIntent<Intent.OnTimeChange> { dispatch(Msg.OnTimeChange(it.value)) }

                onAction<Action.OnVersionChange> { dispatch(Msg.OnVersionChange(it.value)) }
            },
            reducer = {
                when (it) {
                    is Msg.OnTempChange -> copy(temp = it.value)
                    is Msg.OnWindChange -> copy(wind = it.value)
                    is Msg.OnPressureChange -> copy(pressure = it.value)
                    is Msg.OnTimeChange -> copy(time = it.value)
                    is Msg.OnVersionChange -> copy(version = it.value)
                }
            }
        ) {}

}