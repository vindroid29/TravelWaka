package com.globant.travelwaka.logger

import io.github.aakira.napier.Napier
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.MESSAGE

class NapierKoinLogger(level: Level = Level.INFO) : Logger(level) {
    override fun display(level: Level, msg: MESSAGE) {
        when (level) {
            Level.DEBUG -> Napier.d(msg, tag = "KOIN")
            Level.INFO -> Napier.i(msg, tag = "KOIN")
            Level.WARNING -> Napier.w(msg, tag = "KOIN")
            Level.ERROR -> Napier.e(msg, tag = "KOIN")
            Level.NONE -> { /* Do nothing */ }
        }
    }
}