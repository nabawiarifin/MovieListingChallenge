package com.binar.movielistingchallenge.data.movies.favourite

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.binar.movielistingchallenge.data.user.RegisterDAO
import com.binar.movielistingchallenge.data.user.RegisterEntity

@Database(entities = [FavouriteEntity::class], version = 1, exportSchema = false)
abstract class FavouriteDatabase: RoomDatabase() {

    abstract fun favouriteDAO(): FavouriteDAO

    companion object{
        @Volatile
        private var INSTANCE: FavouriteDatabase? = null

        fun getInstance(context: Context): FavouriteDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FavouriteDatabase::class.java,
                        "favourite_movies_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}