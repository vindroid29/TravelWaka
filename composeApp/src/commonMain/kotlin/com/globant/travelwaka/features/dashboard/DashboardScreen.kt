package com.globant.travelwaka.features.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.globant.travelwaka.utils.AppSettings
import dev.icerock.moko.permissions.PermissionState
import dev.icerock.moko.permissions.compose.BindEffect
import dev.icerock.moko.permissions.compose.rememberPermissionsControllerFactory
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import travelwaka.composeapp.generated.resources.Res
import travelwaka.composeapp.generated.resources.login_bg


@Composable
@Preview(showBackground = true)
fun DashboardScreen() {

    val factory = rememberPermissionsControllerFactory()

    val controller = remember(factory) {
        factory.createPermissionsController()
    }


    BindEffect(controller)
    val viewModel = remember {
        DashboardViewModel(controller)
    }
    var stateText by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier.fillMaxSize(), containerColor = Color.Transparent
    ) { innerPadding ->
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(Res.drawable.login_bg),
            contentScale = ContentScale.FillBounds,
            contentDescription = "Travel Waka background"
        )
        Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {
            Text(
                text = "Dashboard...",
                color = Color.White,
                modifier = Modifier.padding(top = innerPadding.calculateTopPadding()),
                style = MaterialTheme.typography.titleLarge
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stateText,
                    color = Color.White,
                    modifier = Modifier.padding(top = innerPadding.calculateTopPadding()),
                    style = MaterialTheme.typography.titleMedium
                )

                when (viewModel.permissionState) {
                    PermissionState.Granted -> {
                        stateText = "Record Audio permission Granted"
                    }

                    PermissionState.DeniedAlways -> {
                        stateText = "Record Audio permission Denied Permanently"

                        MyCustomButton(
                            "Open Settings"
                        ) {
                            AppSettings.open()
                        }
                    }

                    else -> {
                        MyCustomButton(
                            "Request Permission"
                        ) {
                            viewModel.provideOrRequestAudioPermission()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MyCustomButton(text: String, onButtonClick: () -> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth(0.6f),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.background),
        onClick = onButtonClick
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.labelMedium
        )
    }
}