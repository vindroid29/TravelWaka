package com.globant.travelwaka

import android.app.Application
import android.content.Context
import com.globant.travelwaka.di.initKoin
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent

object AppContext {
    lateinit var INSTANCE: Application

    fun initialize(context: Context) {
        INSTANCE = context.applicationContext as Application
    }
}

class MyApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        AppContext.initialize(this)
        Napier.base(DebugAntilog())
        initKoin {
            androidContext(this@MyApplication)
        }
    }
}