package com.globant.travelwaka.data.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

fun getDatabaseBuilder(context: Context): TravelWakaDB {
    val dbFile = context.getDatabasePath("travelwaka.db")
    return Room.databaseBuilder<TravelWakaDB>(
        context = context.applicationContext, name = dbFile.absolutePath
    ).setDriver(BundledSQLiteDriver()).build()
}

