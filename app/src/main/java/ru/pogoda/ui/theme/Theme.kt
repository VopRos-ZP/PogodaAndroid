package ru.pogoda.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@Immutable
data class GradientScheme(
    val background: Brush
)

val LocalGradientScheme = staticCompositionLocalOf<GradientScheme> { error("") }

object PogodaTheme {

    val gradients: GradientScheme
        @Composable @ReadOnlyComposable
        get() = LocalGradientScheme.current

}

private val DarkGradientScheme = GradientScheme(
    background = Brush.linearGradient(
        listOf(
            Color(0xFF06101F),
            Color(0xFF171D2E),
        )
    )
)

private val LightGradientScheme = GradientScheme(
    background = Brush.linearGradient(
        listOf(
            Color(0xFFD2EAFF),
            Color(0xFFF2F9FF),
        )
    )
)

private val DarkColorScheme = darkColorScheme(
    primary = primary80,
    onPrimary = primary20,
    primaryContainer = primary30,
    onPrimaryContainer = primary90,
    inversePrimary = primary80,
    secondary = secondary80,
    onSecondary = secondary20,
    secondaryContainer = secondary30,
    onSecondaryContainer = secondary90,
    tertiary = tertiary80,
    onTertiary = tertiary20,
    tertiaryContainer = tertiary30,
    onTertiaryContainer = tertiary90,
    background = Neutral10,
    onBackground = Neutral90,
    surface = Neutral10,
    onSurface = Neutral90,
    surfaceVariant = NeutralVariant30,
    onSurfaceVariant = NeutralVariant80,
    inverseSurface = Neutral90,
    inverseOnSurface = Neutral20,
    error = Error80,
    onError = Error20,
    errorContainer = Error30,
    onErrorContainer = Error90,
    outline = NeutralVariant60,
    outlineVariant = NeutralVariant40,
    scrim = primary,
    surfaceTint = primary, /*********/
    surfaceBright = primary,
    surfaceDim = primary,
    surfaceContainer = primary,
    surfaceContainerHigh = primary,
    surfaceContainerHighest = primary,
    surfaceContainerLow = primary,
    surfaceContainerLowest = primary,
)

private val LightColorScheme = lightColorScheme(
    primary = primary40,
    onPrimary = primary100,
    primaryContainer = primary90,
    onPrimaryContainer = primary10,
    inversePrimary = primary80,
    secondary = secondary40,
    onSecondary = secondary100,
    secondaryContainer = secondary90,
    onSecondaryContainer = secondary10,
    tertiary = tertiary40,
    onTertiary = tertiary100,
    tertiaryContainer = tertiary90,
    onTertiaryContainer = tertiary10,
    background = Neutral99,
    onBackground = Neutral10,
    surface = Neutral99,
    onSurface = Neutral10,
    surfaceVariant = NeutralVariant90,
    onSurfaceVariant = NeutralVariant30,
    inverseSurface = Neutral20,
    inverseOnSurface = Neutral95,
    error = Error40,
    onError = Error100,
    errorContainer = Error90,
    onErrorContainer = Error10,
    outline = NeutralVariant50,
    outlineVariant = NeutralVariant80,
    scrim = primary,
    surfaceTint = primary, /*********/
    surfaceBright = primary,
    surfaceDim = primary,
    surfaceContainer = primary,
    surfaceContainerHigh = primary,
    surfaceContainerHighest = primary,
    surfaceContainerLow = primary,
    surfaceContainerLowest = primary,
)

@Composable
fun PogodaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val gradientScheme = when {
        darkTheme -> DarkGradientScheme
        else -> LightGradientScheme
    }

    CompositionLocalProvider(
        LocalGradientScheme provides gradientScheme
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}