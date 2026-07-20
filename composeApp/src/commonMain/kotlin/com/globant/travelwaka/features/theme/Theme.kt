package com.globant.travelwaka.features.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val LightColorScheme = lightColorScheme(
    primary = Primary,
    surface = Surface,
    onSurface = OnSurface,
    background = LightBackground,
    onSurfaceVariant = OnSurfaceVariant,
    surfaceContainerLowest = SurfaceLowest,
    onPrimary = Color.White,
    onBackground = Color.Black
)
val DarkColorScheme = darkColorScheme(
    background = DarkBackground,
    onSurface = OnSurfaceDark,
    onBackground = Color.White
)

@Composable
fun TravelWakaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}