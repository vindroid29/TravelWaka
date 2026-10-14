package com.vindroid.travelwaka.features.landing

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import travelwaka.composeapp.generated.resources.Res
import travelwaka.composeapp.generated.resources.app_logo
import travelwaka.composeapp.generated.resources.splash_bg


@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.matchParentSize(),
            painter = painterResource(Res.drawable.splash_bg),
            contentScale = ContentScale.FillBounds,
            contentDescription = "Travel Waka background"
        )
        SplashScreenContent(onTimeout)
    }

}

@Composable
fun SplashScreenContent(onTimeout: () -> Unit) {
    val scale = remember { Animatable(0.5f) }
    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 2000)
        )
        delay(1000)
        onTimeout()
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .scale(scale.value),
                painter = painterResource(Res.drawable.app_logo),
                contentDescription = "Travel Waka Logo"
            )
            Text(
                text = "Travel Waka",
                color = Color.White,
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "find out where you wan waka go",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }

    }
}


@Composable
@Preview(showBackground = true)
fun DefaultSplashPreview() {
    SplashScreen {}
}