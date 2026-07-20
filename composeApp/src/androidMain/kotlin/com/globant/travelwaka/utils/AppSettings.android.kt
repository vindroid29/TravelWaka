package com.globant.travelwaka.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.util.Log
import com.globant.travelwaka.logger.logMessage

actual object AppSettings {

    actual fun open(context: Any?) {
        try {
            val context = context as? Context ?: return

            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                data = Uri.fromParts("package", context.packageName, null)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Log.e("AppSettings", "Failed to open app settings ${e.message}")
            logMessage("AppSettings", "Failed to open app settings")
        }

    }
}