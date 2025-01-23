package ru.pogoda.ui.components.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.pogoda.ui.compose.BackTopBar
import ru.pogoda.ui.theme.PogodaTheme

@Composable
fun ThemeScreen(component: ThemeComponent) {
    val themeOpts = arrayOf("Светлая", "Темная", "Системная")

    val state by component.state.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PogodaTheme.gradients.background)
    ) {
        BackTopBar(
            onClick = { component.onBackClick() },
            text = "Тема",
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
                themeOpts.forEachIndexed { i, t ->
                    SegmentedButton(
                        selected = state.theme == i,
                        onClick = { component.onThemeChange(i) },
                        shape = SegmentedButtonDefaults.itemShape(
                            index = i,
                            count = themeOpts.size
                        ),
                        label = {
                            Text(
                                text = t,
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        },
                        colors = SegmentedButtonDefaults.colors(
                            activeContainerColor = MaterialTheme.colorScheme.primary,
                            activeBorderColor = MaterialTheme.colorScheme.primary,
                            inactiveBorderColor = MaterialTheme.colorScheme.primary,
                            activeContentColor = MaterialTheme.colorScheme.onPrimary
                        ),
                    )
                }
            }
        }
    }
}