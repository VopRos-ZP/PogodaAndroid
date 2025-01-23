package ru.pogoda.ui.compose

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import ru.pogoda.R

@Composable
fun BackTopBar(
    onClick: () -> Unit,
    text: String = "",
    style: TextStyle = MaterialTheme.typography.titleLarge,
) {
    TopBar(
        navigationIcon = {
            IconButton(
                onClick = onClick,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.secondary
                )
            ) {
                Icon(
                    ImageVector.vectorResource(R.drawable.ic_arrow_back),
                    contentDescription = null
                )
            }
        },
        text = text,
        style = style
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navigationIcon: @Composable () -> Unit = {},
    text: String = "",
    style: TextStyle = MaterialTheme.typography.titleLarge,
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        navigationIcon = navigationIcon,
        title = {
            Text(
                text = text,
                style = style,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    )
}