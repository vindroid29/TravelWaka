package com.vindroid.travelwaka.features.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.vindroid.travelwaka.features.common.LogoTagline
import com.vindroid.travelwaka.features.theme.Primary
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import travelwaka.composeapp.generated.resources.Res
import travelwaka.composeapp.generated.resources.login_bg


enum class LoginControls {
    SIGN_IN, SIGN_UP, SKIP
}

@Composable
fun LoginOnboardingScreen(onControlClick: (LoginControls) -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(Res.drawable.login_bg),
            contentScale = ContentScale.FillBounds,
            contentDescription = "Travel Waka background"
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.weight(0.2f))
            LogoTagline(Modifier.wrapContentSize())
            Spacer(modifier = Modifier.weight(1f))
            Button(
                modifier = Modifier.fillMaxWidth(0.6f),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Primary),
                onClick = {

                    onControlClick(LoginControls.SIGN_IN)
                }) {
                Text(
                    text = "Sign In", style = MaterialTheme.typography.labelMedium
                )
            }
            Button(
                modifier = Modifier.fillMaxWidth(0.6f),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.background),
                onClick = {
                    onControlClick(LoginControls.SIGN_UP)
                }) {
                Text(
                    text = "Sign Up",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelMedium
                )
            }
            Text(
                modifier = Modifier.padding(8.dp).clickable(enabled = true, onClick = {
                    onControlClick(LoginControls.SKIP)
                }),
                text = "Skip for now",
                color = Color.White,
                style = MaterialTheme.typography.labelSmall,
            )
            Spacer(modifier = Modifier.weight(0.2f))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewLoginScreen() {
    LoginOnboardingScreen {}
}