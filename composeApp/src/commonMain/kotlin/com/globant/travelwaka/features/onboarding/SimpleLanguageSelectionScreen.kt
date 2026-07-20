package com.globant.travelwaka.features.onboarding

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.globant.travelwaka.logger.logMessage
import io.github.aakira.napier.Napier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SimpleLanguageSelectionScreen(continueClick: () -> Unit) {
    val languageOptions = listOf("English", "Yoruba", "Hausa", "Pidgin")
    var selectedLanguage by remember { mutableStateOf(languageOptions.first()) }
    val primaryBlue = Color(0xFF007AFF)
    Column(
        modifier = Modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.wrapContentSize()
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(MaterialTheme.colorScheme.background).padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            languageOptions.forEach { currentLanguage ->
                val isSelected = (currentLanguage == selectedLanguage)
                val cardColor by animateColorAsState(if (isSelected) MaterialTheme.colorScheme.background else primaryBlue)
                val textColor by animateColorAsState(if (isSelected) MaterialTheme.colorScheme.onBackground else Color.White)
                val borderWidth by animateDpAsState(if (isSelected) 0.dp else 1.dp)

                Surface(
                    tonalElevation = 4.dp,
                    shadowElevation = 4.dp,
                    onClick = {
                        selectedLanguage = currentLanguage
                        logMessage("LanguageSelection", "Selected : $selectedLanguage")
                    },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).selectable(
                        selected = isSelected,
                        onClick = { selectedLanguage = currentLanguage },
                        role = Role.RadioButton
                    ),
                    shape = RoundedCornerShape(8.dp),
                    color = cardColor,
                    border = BorderStroke(borderWidth, Color.LightGray)
                ) {
                    Box(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = currentLanguage,
                            color = textColor,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }

        Button(
            onClick = {
                continueClick()
            },
            modifier = Modifier.fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = primaryBlue),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(
                "Continue", color = Color.White, style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun LanguageSelectionDefaultPreview() {
    SimpleLanguageSelectionScreen {}
}