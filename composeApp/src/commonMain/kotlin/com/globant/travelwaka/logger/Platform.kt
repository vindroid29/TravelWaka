package com.globant.travelwaka.logger

expect fun getTagName(): String

expect val isDebug: Boolean

enum class PlatformState {
    ANDROID,
    IOS
}

expect fun getPlatform(): PlatformState

expect val isAndroid : Boolean