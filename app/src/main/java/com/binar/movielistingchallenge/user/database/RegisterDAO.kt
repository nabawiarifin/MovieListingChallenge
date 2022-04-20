package com.binar.movielistingchallenge.user.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RegisterDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(registerEntity: RegisterEntity): Long

    @Query("SELECT * FROM register_user_table WHERE username LIKE :userName")
    suspend fun getUsername(userName: String): RegisterEntity?
}