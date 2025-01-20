package ru.pogoda.ui.components.daily

import kotlinx.coroutines.flow.StateFlow

interface DailyComponent {
    val state: StateFlow<Daily.State>

    fun onBackClick()
}