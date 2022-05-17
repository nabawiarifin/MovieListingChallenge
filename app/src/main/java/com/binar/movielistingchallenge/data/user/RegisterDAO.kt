package com.binar.movielistingchallenge.data.user

import androidx.room.*

@Dao
interface RegisterDAO {

    // For inserting single user
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(registerEntity: RegisterEntity): Long

    // Checking where the user exist or not in our db
    @Query("SELECT * FROM register_user_table WHERE username LIKE :username AND password LIKE :password")
    suspend fun getUser(username: String, password: String): RegisterEntity

    //Delete all users from database
    @Query ("DELETE FROM register_user_table")
    fun deleteAll()

//    @Update
//    suspend fun updateUser(registerEntity: RegisterEntity): Long



}