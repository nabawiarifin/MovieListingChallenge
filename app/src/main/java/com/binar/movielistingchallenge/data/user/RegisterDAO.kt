package com.binar.movielistingchallenge.data.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RegisterDAO {

    // For inserting single user
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(registerEntity: RegisterEntity): Long

    // Checking where the user exist or not in our db
    @Query("SELECT * FROM register_user_table WHERE username LIKE :username AND password LIKE :password")
    fun getUser(username: String, password: String): RegisterEntity

    //Delete all users from database
    @Query ("DELETE FROM register_user_table")
    fun deleteAll()


}