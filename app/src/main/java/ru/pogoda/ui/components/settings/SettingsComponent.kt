package ru.pogoda.ui.components.settings

interface SettingsComponent {
    fun onBackClick()
    fun onTempChange(temp: Int)
    fun onWindChange(wind: Int)
    fun onPressureChange(value: Int)
    fun onTimeChange(value: Int)
    fun onIconChangeClick()
    fun onThemeChangeClick()
}