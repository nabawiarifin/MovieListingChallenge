package com.binar.movielistingchallenge.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.binar.movielistingchallenge.data.movies.MovieModel
import com.binar.movielistingchallenge.data.movies.Movies
import com.binar.movielistingchallenge.data.movies.favourite.FavouriteDAO
import com.binar.movielistingchallenge.data.movies.favourite.FavouriteEntity
import com.binar.movielistingchallenge.network.movies.network.MovieApi
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val dao: FavouriteDAO) {

    //Get movies from web
    val movies: MutableLiveData<List<Movies>> by lazy {
        MutableLiveData<List<Movies>>().also {
            getAllMovies()
        }
    }

    private fun getAllMovies(){
        MovieApi.retrofitService.getMovies().enqueue(object : retrofit2.Callback<MovieModel> {
            override fun onResponse(
                call: Call<MovieModel>,
                response: Response<MovieModel>
            ) {
                movies.value = response.body()?.results
            }

            override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                Log.d("Tag",t.message.toString())
            }

        })
    }

    //Get movies from room database
    private suspend fun getFavouriteMovies(): List<FavouriteEntity> = dao.getFavouriteMovies()

    suspend fun insertFavouriteMovie(favouriteEntity: FavouriteEntity): Long {
        return dao.insertFavouriteMovie(favouriteEntity)
    }
}