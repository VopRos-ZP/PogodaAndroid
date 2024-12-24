package ru.pogoda.ui.components.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import ru.pogoda.ui.theme.PogodaTheme

@Composable
fun MainScreen(component: MainComponent) {
    val state by component.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PogodaTheme.gradients.background)
    ) {
        Text(text = "${state.fact.fact?.temp}")
    }
}