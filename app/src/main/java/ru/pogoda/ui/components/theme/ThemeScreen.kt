package ru.pogoda.ui.components.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.pogoda.R
import ru.pogoda.ui.compose.BackTopBar
import ru.pogoda.ui.compose.Buttons
import ru.pogoda.ui.compose.LogoButton
import ru.pogoda.ui.theme.PogodaTheme

@Composable
fun ThemeScreen(component: ThemeComponent) {
    val themeOpts = arrayOf("Светлая", "Темная", "Системная")
    val logoOpts = arrayOf(R.drawable.sun_logo, R.drawable.rain_logo)

    val state by component.state.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PogodaTheme.gradients.background)
    ) {
        BackTopBar(
            onClick = { component.onBackClick() },
            text = "Расширенные настройки",
            style = MaterialTheme.typography.titleLarge,
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(
                    color = MaterialTheme.colorScheme.onSecondary,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(horizontal = 16.dp, vertical = 20.dp)
        ) {
            SingleChoiceSegmentedButtonRow(
                modifier = Modifier
            ) {
                Buttons(
                    state = state.theme,
                    opts = themeOpts,
                    onClick = { component.onThemeChange(it) },
                    format = { it }
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Смена иконки",
                style = MaterialTheme.typography.titleMedium
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                logoOpts.forEachIndexed { i, logo ->
                    LogoButton(
                        logo = logo,
                        isChecked = state.logo == i,
                        onCheckedChange = { component.onLogoChange(i) }
                    )
                }
            }
        }
    }
}
