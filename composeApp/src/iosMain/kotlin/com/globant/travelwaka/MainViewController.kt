package com.globant.travelwaka

import androidx.compose.ui.window.ComposeUIViewController
import com.globant.travelwaka.di.initKoin
import com.globant.travelwaka.logger.IosLogger
import io.github.aakira.napier.Napier

fun MainViewController() = ComposeUIViewController(
    configure = {
        Napier.base(IosLogger())
        initKoin()
    }
) {
    App()
}

