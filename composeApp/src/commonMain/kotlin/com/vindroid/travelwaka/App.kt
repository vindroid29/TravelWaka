package com.vindroid.travelwaka

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.vindroid.travelwaka.features.dashboard.DashboardScreen
import com.vindroid.travelwaka.features.landing.SplashScreen
import com.vindroid.travelwaka.features.login.LoginControls
import com.vindroid.travelwaka.features.login.LoginOnboardingScreen
import com.vindroid.travelwaka.features.navigation.Route
import com.vindroid.travelwaka.features.onboarding.LanguageSelectionScreen
import com.vindroid.travelwaka.features.theme.TravelWakaTheme
import com.vindroid.travelwaka.logger.logMessage
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun App() {
    TravelWakaTheme {
        val navConfig = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(Route.SplashScreen::class)
                    subclass(Route.OnBoardingScreen::class)
                    subclass(Route.LoginOnboardingScreen::class)
                    subclass(Route.LanguageSelectionScreen::class)
                    subclass(Route.DashboardScreen::class)
                }
            }
        }
        val backStack = rememberNavBackStack(
            configuration = navConfig,
            Route.SplashScreen
        )
        NavDisplay(
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                entry<Route.SplashScreen> {
                    SplashScreen {
                        backStack.run {
                            removeLastOrNull()
                            add(Route.LanguageSelectionScreen)
                        }
                    }
                }
                entry<Route.LanguageSelectionScreen> {
                    LanguageSelectionScreen {
                        backStack.add(Route.LoginOnboardingScreen)
                    }
                }
                entry<Route.LoginOnboardingScreen> {
                    LoginOnboardingScreen { controls ->
                        when (controls) {
                            LoginControls.SIGN_IN -> {
                                logMessage("singIn", "Sign in Clicked")
                            }

                            LoginControls.SIGN_UP -> {
                                logMessage("singIn", "Sign Up Clicked")
                            }

                            LoginControls.SKIP -> {
                                backStack.add(Route.DashboardScreen)
                            }
                        }
                    }
                }
                entry<Route.DashboardScreen> {
                    DashboardScreen()
                }
            })
    }
}

@Composable
@Preview(showBackground = true)
fun DefaultSplashPreview() {
    App()
}