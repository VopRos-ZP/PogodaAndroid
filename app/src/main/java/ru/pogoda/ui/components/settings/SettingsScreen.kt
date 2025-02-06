package ru.pogoda.ui.components.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import ru.pogoda.R
import ru.pogoda.ui.compose.BackTopBar
import ru.pogoda.ui.compose.Buttons
import ru.pogoda.ui.theme.Neutral35
import ru.pogoda.ui.theme.PogodaTheme

@Composable
fun SettingsScreen(component: SettingsComponent) {
    val state by component.state.collectAsState()
    // Options
    val tempOpts = arrayOf("℃", "°F")
    val windOpts = arrayOf("м/с", "км/ч")
    val pressureOpts = arrayOf("мм рт. ст.", "гПа")
    val timeOpts = arrayOf("24ч", "12ч")

    // UI
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PogodaTheme.gradients.background)
    ) {
        BackTopBar(
            onClick = { component.onBackClick() },
            text = "Настройки"
        )
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        modifier = Modifier.weight(0.5f),
                        text = "Температура",
                        style = MaterialTheme.typography.titleMedium,
                    )
                    SingleChoiceSegmentedButtonRow(
                        modifier = Modifier.weight(1f)
                    ) {
                        Buttons(
                            state = state.temp,
                            opts = tempOpts,
                            onClick = { component.onTempChange(it) },
                            format = { it }
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        modifier = Modifier.weight(0.5f),
                        text = "Ветер",
                        style = MaterialTheme.typography.titleSmall,
                    )
                    SingleChoiceSegmentedButtonRow(
                        modifier = Modifier.weight(1f)
                    ) {
                        Buttons(
                            state = state.wind,
                            opts = windOpts,
                            onClick = { component.onWindChange(it) },
                            format = { it }
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        modifier = Modifier.weight(0.5f),
                        text = "Давление",
                        style = MaterialTheme.typography.titleSmall,
                    )
                    SingleChoiceSegmentedButtonRow(
                        modifier = Modifier.weight(1f)
                    ) {
                        Buttons(
                            state = state.pressure,
                            opts = pressureOpts,
                            onClick = { component.onPressureChange(it) },
                            format = { it }
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        modifier = Modifier.weight(0.5f),
                        text = "Время",
                        style = MaterialTheme.typography.titleMedium,
                    )
                    SingleChoiceSegmentedButtonRow(
                        modifier = Modifier.weight(1f)
                    ) {
                        Buttons(
                            state = state.time,
                            opts = timeOpts,
                            onClick = { component.onTimeChange(it) },
                            format = { it }
                        )
                    }
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { component.onThemeChangeClick() }
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Расширенные настройки",
                        style = MaterialTheme.typography.titleMedium,
                    )
                    Icon(
                        ImageVector.vectorResource(R.drawable.arrow_forward),
                        contentDescription = null
                    )
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { component.onPoliticsClick() }
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Политика конфиденциальности",
                        style = MaterialTheme.typography.titleMedium,
                    )
                    Icon(
                        ImageVector.vectorResource(R.drawable.arrow_forward),
                        contentDescription = null
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { component.onConditionUseClick() }
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Условия использования",
                        style = MaterialTheme.typography.titleMedium,
                    )
                    Icon(
                        ImageVector.vectorResource(R.drawable.arrow_forward),
                        contentDescription = null
                    )
                }
            }
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { component.onLocationClick() }
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Настройки местоположения",
                        style = MaterialTheme.typography.titleMedium,
                    )
                    Icon(
                        ImageVector.vectorResource(R.drawable.arrow_forward),
                        contentDescription = null
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Версия",
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = state.version,
                    style = MaterialTheme.typography.titleMedium,
                    color = Neutral35
                )
            }
        }
    }
}
