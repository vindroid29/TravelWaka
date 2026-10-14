package com.vindroid.travelwaka.logger

import io.github.aakira.napier.Antilog
import io.github.aakira.napier.LogLevel

class IosLogger : Antilog() {
    override fun performLog(priority: LogLevel, tag: String?, throwable: Throwable?, message: String?) {
        val fullMessage = if (tag != null) "[$tag] $message" else message
        println(fullMessage) // Standard Kotlin print targets Xcode console
    }
}