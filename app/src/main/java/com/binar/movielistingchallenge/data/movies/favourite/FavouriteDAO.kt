package com.binar.movielistingchallenge.data.movies.favourite

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.binar.movielistingchallenge.data.user.RegisterEntity

@Dao
interface FavouriteDAO {

    // For inserting single user
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavouriteMovie(favouriteEntity: FavouriteEntity): Long

    @Query("SELECT * from favourite_movies_table")
    suspend fun getFavouriteMovies(): List<FavouriteEntity>

}