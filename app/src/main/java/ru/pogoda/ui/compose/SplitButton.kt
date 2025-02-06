package ru.pogoda.ui.compose

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRowScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun <T : Any> SingleChoiceSegmentedButtonRowScope.Buttons(
    state: Int,
    opts: Array<T>,
    onClick: (Int) -> Unit,
    format: (T) -> String = { it.toString() },
) {
    opts.mapIndexed { i, t ->
        SegmentedButton(
            selected = state == i,
            onClick = { onClick(i) },
            shape = SegmentedButtonDefaults.itemShape(
                index = i,
                count = opts.size
            ),
            colors = SegmentedButtonDefaults.colors(
                activeContainerColor = MaterialTheme.colorScheme.primary,
                activeBorderColor = MaterialTheme.colorScheme.primary,
                inactiveBorderColor = MaterialTheme.colorScheme.primary,
                activeContentColor = MaterialTheme.colorScheme.onPrimary
            ),
        ) {
            Text(
                text = format(t),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}