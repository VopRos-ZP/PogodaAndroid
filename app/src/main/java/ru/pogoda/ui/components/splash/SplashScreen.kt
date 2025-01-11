package ru.pogoda.ui.components.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import kotlinx.coroutines.delay
import ru.pogoda.R
import ru.pogoda.ui.theme.PogodaTheme

@Composable
fun SplashScreen(component: SplashComponent) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = PogodaTheme.gradients.background),
        contentAlignment = Alignment.Center
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.logo),
            contentDescription = "Logo",
        )
    }
    LaunchedEffect(Unit) {
        delay(1000)
        component.checkPermissions()
    }
}