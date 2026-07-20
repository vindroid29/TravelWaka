package com.globant.travelwaka.di

import com.globant.travelwaka.logger.NapierKoinLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        logger(NapierKoinLogger(Level.DEBUG))
        modules(
            viewModelModule, provideRepositoryModule, provideUseCaseModule, platformModule()
        )
    }
}