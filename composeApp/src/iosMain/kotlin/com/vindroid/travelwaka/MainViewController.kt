package com.vindroid.travelwaka

import androidx.compose.ui.window.ComposeUIViewController
import com.vindroid.travelwaka.di.initKoin
import com.vindroid.travelwaka.logger.IosLogger
import io.github.aakira.napier.Napier

fun MainViewController() = ComposeUIViewController(
    configure = {
        Napier.base(IosLogger())
        initKoin()
    }
) {
    App()
}

