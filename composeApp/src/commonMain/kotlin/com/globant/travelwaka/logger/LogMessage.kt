package com.globant.travelwaka.logger

import io.github.aakira.napier.Napier


fun logMessage(tag: String = getTagName(), message: String) {
    Napier.d(tag = tag, message = message)
}