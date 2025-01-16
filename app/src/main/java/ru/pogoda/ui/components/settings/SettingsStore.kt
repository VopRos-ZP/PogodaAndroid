package ru.pogoda.ui.components.settings

import com.arkivanov.mvikotlin.core.store.Store

interface SettingsStore : Store<Settings.Intent, Settings.State, Settings.Label>