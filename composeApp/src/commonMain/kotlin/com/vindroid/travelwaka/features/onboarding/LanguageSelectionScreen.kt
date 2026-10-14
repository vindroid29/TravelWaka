package com.vindroid.travelwaka.features.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import com.vindroid.travelwaka.features.common.LogoTagline
import com.vindroid.travelwaka.logger.isAndroid
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import travelwaka.composeapp.generated.resources.Res
import travelwaka.composeapp.generated.resources.language_selection_bg

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageSelectionScreen(continueClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(Res.drawable.language_selection_bg),
            contentScale = ContentScale.FillBounds,
            contentDescription = "Travel Waka background"
        )
        LanguageSelectionContent(
            continueClick
        )
    }
}

@Composable
fun LanguageSelectionContent(continueClick: () -> Unit) {
    var isVisible by remember { mutableStateOf(false) }
    var headerOffsetY by remember { mutableFloatStateOf(0f) }
    LaunchedEffect(Unit) {
        delay(500L)
        isVisible = true
    }
    val windowInsets = if (isAndroid) WindowInsets.safeDrawing else WindowInsets(0, 0, 0, 0)

    Box(modifier = Modifier.fillMaxSize().windowInsetsPadding(windowInsets)) {
        Column(
            modifier = Modifier.fillMaxWidth().graphicsLayer { translationY = headerOffsetY },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxSize().weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LogoTagline(
                    Modifier.wrapContentSize().weight(0.1f)
                )

                AnimatedVisibility(
                    visible = isVisible,
                    enter = slideInVertically(
                        initialOffsetY = { fullHeight -> fullHeight }, // Starts from below the screen
                        animationSpec = tween(durationMillis = 500)
                    ) + fadeIn(animationSpec = tween(durationMillis = 300)),
                    exit = slideOutVertically(
                        targetOffsetY = { fullHeight -> fullHeight }, // Slides back down
                        animationSpec = tween(durationMillis = 500)
                    ) + fadeOut(animationSpec = tween(durationMillis = 300))
                ) {
                    SimpleLanguageSelectionScreen(
                        continueClick
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    LanguageSelectionScreen {}
}

