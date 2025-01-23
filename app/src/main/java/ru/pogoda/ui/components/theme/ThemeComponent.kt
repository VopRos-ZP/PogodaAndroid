package ru.pogoda.ui.components.theme

import kotlinx.coroutines.flow.StateFlow

interface ThemeComponent {
    val state: StateFlow<Theme.State>

    fun onBackClick()
    fun onThemeChange(value: Int)
}