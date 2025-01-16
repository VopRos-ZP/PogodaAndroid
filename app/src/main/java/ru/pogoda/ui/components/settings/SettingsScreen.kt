package ru.pogoda.ui.components.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.pogoda.R
import ru.pogoda.ui.theme.Neutral35
import ru.pogoda.ui.theme.PogodaTheme

@OptIn(ExperimentalMaterial3Api::class)
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
            .background(PogodaTheme.gradients.background),
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent
            ),
            navigationIcon = {
                IconButton(
                    onClick = { component.onBackClick() }
                ) {
                    Icon(
                        ImageVector.vectorResource(R.drawable.ic_arrow_back),
                        contentDescription = null,
                    )
                }
            },
            title = {
                Text(
                    text = "Настройки"
                )
            }
        )
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
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(0.55f),
                    text = "Температура",
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.width(31.dp))
                SingleChoiceSegmentedButtonRow(
                    modifier = Modifier.weight(1f)
                ) {
                    tempOpts.forEachIndexed { i, t ->
                        SegmentedButton(
                            modifier = Modifier.weight(1f),
                            selected = state.temp == i,
                            onClick = { component.onTempChange(i) },
                            shape = SegmentedButtonDefaults.itemShape(
                                index = i,
                                count = tempOpts.size
                            ),
                            colors = SegmentedButtonDefaults.colors(
                                activeContainerColor = MaterialTheme.colorScheme.primary,
                                activeBorderColor = MaterialTheme.colorScheme.primary,
                                inactiveBorderColor = MaterialTheme.colorScheme.primary,
                                activeContentColor = MaterialTheme.colorScheme.onPrimary
                            ),
                        ) {
                            Text(
                                text = t,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(0.55f),
                    text = "Ветер",
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.width(31.dp))
                SingleChoiceSegmentedButtonRow(
                    modifier = Modifier.weight(1f)
                ) {
                    windOpts.forEachIndexed { i, t ->
                        SegmentedButton(
                            modifier = Modifier.weight(1f),
                            selected = state.wind == i,
                            onClick = { component.onWindChange(i) },
                            shape = SegmentedButtonDefaults.itemShape(
                                index = i,
                                count = windOpts.size
                            ),
                            colors = SegmentedButtonDefaults.colors(
                                activeContainerColor = MaterialTheme.colorScheme.primary,
                                activeBorderColor = MaterialTheme.colorScheme.primary,
                                inactiveBorderColor = MaterialTheme.colorScheme.primary,
                                activeContentColor = MaterialTheme.colorScheme.onPrimary
                            ),
                        ) {
                            Text(
                                text = t,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(0.55f),
                    text = "Давление",
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.width(31.dp))
                SingleChoiceSegmentedButtonRow(
                    modifier = Modifier.weight(1f)
                ) {
                    pressureOpts.forEachIndexed { i, t ->
                        SegmentedButton(
                            modifier = Modifier.weight(1f),
                            selected = state.pressure == i,
                            onClick = { component.onPressureChange(i) },
                            shape = SegmentedButtonDefaults.itemShape(
                                index = i,
                                count = pressureOpts.size
                            ),
                            colors = SegmentedButtonDefaults.colors(
                                activeContainerColor = MaterialTheme.colorScheme.primary,
                                activeBorderColor = MaterialTheme.colorScheme.primary,
                                inactiveBorderColor = MaterialTheme.colorScheme.primary,
                                activeContentColor = MaterialTheme.colorScheme.onPrimary
                            ),
                        ) {
                            Text(
                                text = t,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(0.55f),
                    text = "Время",
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.width(31.dp))
                SingleChoiceSegmentedButtonRow(
                    modifier = Modifier.weight(1f)
                ) {
                    timeOpts.forEachIndexed { i, t ->
                        SegmentedButton(
                            modifier = Modifier.weight(1f),
                            selected = state.time == i,
                            onClick = { component.onTimeChange(i) },
                            shape = SegmentedButtonDefaults.itemShape(
                                index = i,
                                count = timeOpts.size
                            ),
                            colors = SegmentedButtonDefaults.colors(
                                activeContainerColor = MaterialTheme.colorScheme.primary,
                                activeBorderColor = MaterialTheme.colorScheme.primary,
                                inactiveBorderColor = MaterialTheme.colorScheme.primary,
                                activeContentColor = MaterialTheme.colorScheme.onPrimary
                            ),
                        ) {
                            Text(
                                text = t,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
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
                    .clickable {  }
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Смена иконки приложения",
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
                    .clickable {  }
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Тема",
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
                    .clickable {  }
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
                    .clickable {  }
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
                    .clickable {  }
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
