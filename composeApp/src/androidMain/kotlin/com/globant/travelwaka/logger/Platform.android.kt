package com.globant.travelwaka.logger

import com.globant.travelwaka.AppContext
import com.globant.travelwaka.BuildConfig
import com.globant.travelwaka.R

actual fun getTagName(): String {
    return AppContext.INSTANCE.getString(R.string.tag_name)
}

actual val isDebug: Boolean = BuildConfig.DEBUG

actual fun getPlatform() = PlatformState.ANDROID

actual val isAndroid = getPlatform() == PlatformState.ANDROID
