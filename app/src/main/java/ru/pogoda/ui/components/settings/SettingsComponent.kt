package ru.pogoda.ui.components.settings

import kotlinx.coroutines.flow.StateFlow

interface SettingsComponent {
    val state: StateFlow<Settings.State>

    fun onBackClick()
    fun onTempChange(value: Int)
    fun onWindChange(value: Int)
    fun onPressureChange(value: Int)
    fun onTimeChange(value: Int)
    fun onIconChangeClick()
    fun onThemeChangeClick()
    fun onPoliticsClick()
    fun onConditionUseClick()
    fun onLocationClick()
}