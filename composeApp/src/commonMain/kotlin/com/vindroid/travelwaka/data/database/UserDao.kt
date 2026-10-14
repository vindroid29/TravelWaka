package com.vindroid.travelwaka.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert

@Dao
interface UserDao {

    @Upsert
    fun insertUser()

    @Delete
    fun delete(user: User)
}