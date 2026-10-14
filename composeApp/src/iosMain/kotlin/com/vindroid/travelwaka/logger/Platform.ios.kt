package com.vindroid.travelwaka.logger

import platform.Foundation.NSBundle
import kotlin.experimental.ExperimentalNativeApi

actual fun getTagName(): String {
    return NSBundle.mainBundle.objectForInfoDictionaryKey("CFBundleName") as? String
        ?: NSBundle.mainBundle.objectForInfoDictionaryKey("CFBundleDisplayName") as? String
        ?: "UnknowniOSApp"
}

@OptIn(ExperimentalNativeApi::class)
actual val isDebug: Boolean = Platform.isDebugBinary

actual fun getPlatform() = PlatformState.IOS

actual val isAndroid = getPlatform() == PlatformState.ANDROID