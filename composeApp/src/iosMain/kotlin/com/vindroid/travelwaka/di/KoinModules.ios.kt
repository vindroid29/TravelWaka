package com.vindroid.travelwaka.di

import com.vindroid.travelwaka.data.database.TravelWakaDB
import com.vindroid.travelwaka.data.database.getDatabaseBuilder
import org.koin.core.module.Module
import org.koin.dsl.module
import kotlin.experimental.ExperimentalNativeApi

@OptIn(ExperimentalNativeApi::class)
actual fun platformModule(): Module = module {
    single<TravelWakaDB> { getDatabaseBuilder() }
}
