package com.globant.travelwaka.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class TravelWakaDB : RoomDatabase(), DB {
    //Add dao classes
    abstract fun userDao(): UserDao

    override fun clearAllTables() {
        //TODO clear tables
    }
}


interface DB {
    fun clearAllTables()
}