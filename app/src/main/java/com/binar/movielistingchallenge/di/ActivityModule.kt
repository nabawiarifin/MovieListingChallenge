package com.binar.movielistingchallenge.di

import android.app.Application
import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.room.Room
import com.binar.movielistingchallenge.data.movies.favourite.FavouriteDatabase
import com.binar.movielistingchallenge.data.user.RegisterDAO
import com.binar.movielistingchallenge.data.user.RegisterDatabase
import com.binar.movielistingchallenge.repositories.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/** For dependencies that live for the whole lifetime of application
 * eg: Retrofit, RoomDatabase
 */

@Module
@InstallIn(SingletonComponent::class)
object ActivityModule {

    @Singleton // Tell Dagger-Hilt to create a singleton accessible everywhere in ApplicationCompenent (i.e. everywhere in the application)
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        RegisterDatabase::class.java,
        "user_details_database"
    ).build() // The reason we can construct a database for the repo

    @Singleton // Tell Dagger-Hilt to create a singleton accessible everywhere in ApplicationCompenent (i.e. everywhere in the application)
    @Provides
    fun provideFavouriteDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        FavouriteDatabase::class.java,
        "favourite_movies_database"
    ).build() // The reason we can construct a database for the repo

    @Singleton
    @Provides
    fun provideYourDao(db: RegisterDatabase) = db.registerDAO() // The reason we can implement a Dao for the database

    @Singleton
    @Provides
    fun provideFavouriteDao(db: FavouriteDatabase) = db.favouriteDAO() // The reason we can implement a Dao for the database

    //Api
    @Singleton
    @Provides
    fun provideMovieApi(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.themoviedb.org/")
        .build()




}