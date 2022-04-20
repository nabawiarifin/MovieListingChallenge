package com.binar.movielistingchallenge.user.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RegisterEntity::class], version = 1)
abstract class RegisterDatabase: RoomDatabase() {
    abstract fun registerDAO(): RegisterDAO

    companion object{
        private var INSTANCE: RegisterDatabase? = null

        fun getInstance(context: Context): RegisterDatabase? {
            if(INSTANCE == null){
                synchronized(RegisterDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, RegisterDatabase::class.java, "Register.db")
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}