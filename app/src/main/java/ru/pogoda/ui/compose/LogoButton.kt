package ru.pogoda.ui.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

@Composable
fun LogoButton(
    logo: Int,
    isChecked: Boolean,
    onCheckedChange: () -> Unit,
) {
    val shape = RoundedCornerShape(13.dp)
    val borderStroke = when (isChecked) {
        true -> BorderStroke(2.dp, Color.Red)
        else -> BorderStroke(0.dp, Color.Transparent)
    }
    Box(
        modifier = Modifier
            .size(60.dp)
            .background(MaterialTheme.colorScheme.onPrimary, shape)
            .border(borderStroke, shape)
            .clip(shape)
            .clickable { onCheckedChange() },
        contentAlignment = Alignment.Center
    ) {
        ImageVector.vectorResource(logo).let {
            Image(
                imageVector = it,
                contentDescription = it.name,
                modifier = Modifier.size(50.dp)
            )
        }
    }
}