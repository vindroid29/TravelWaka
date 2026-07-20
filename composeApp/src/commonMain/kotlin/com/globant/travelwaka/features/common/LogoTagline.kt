package com.globant.travelwaka.features.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import travelwaka.composeapp.generated.resources.Res
import travelwaka.composeapp.generated.resources.app_logo


@Composable
fun LogoTagline(modifier: Modifier){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier.size(80.dp),
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