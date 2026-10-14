package com.vindroid.travelwaka.logger

import com.vindroid.travelwaka.AppContext
import com.vindroid.travelwaka.BuildConfig
import com.vindroid.travelwaka.R

actual fun getTagName(): String {
    return AppContext.INSTANCE.getString(R.string.tag_name)
}

actual val isDebug: Boolean = BuildConfig.DEBUG

actual fun getPlatform() = PlatformState.ANDROID

actual val isAndroid = getPlatform() == PlatformState.ANDROID
