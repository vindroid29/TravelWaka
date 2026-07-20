package com.globant.travelwaka.utils

import platform.Foundation.NSURL
import platform.UIKit.UIApplication
import platform.UIKit.UIApplicationOpenSettingsURLString

actual object AppSettings {

    actual fun open(context: Any?) {
        val settingsUrl = NSURL.URLWithString(UIApplicationOpenSettingsURLString)
        settingsUrl?.let {
            UIApplication.sharedApplication.openURL(
                url = it, options = emptyMap<Any?, Any>(), completionHandler = null
            )
        }
    }
}