package com.vindroid.travelwaka.features.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


@Serializable
sealed interface Route : NavKey {
    @Serializable
    data object SplashScreen : Route

    @Serializable
    data object OnBoardingScreen : Route

    @Serializable
    data object LanguageSelectionScreen : Route

    @Serializable
    data object LoginOnboardingScreen : Route

    @Serializable
    data object DashboardScreen : Route
}