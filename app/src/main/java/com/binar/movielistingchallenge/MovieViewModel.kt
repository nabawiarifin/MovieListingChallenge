package com.binar.movielistingchallenge

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binar.movielistingchallenge.model.MovieModel
import com.binar.movielistingchallenge.model.Movies
import com.binar.movielistingchallenge.network.MovieApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//Andre
class MovieViewModel : ViewModel() {

    private val movies: MutableLiveData<List<Movies>> by lazy {
        MutableLiveData<List<Movies>>().also {
            getAllMovies()
        }
    }

    fun getMovies(): LiveData<List<Movies>>{
        return movies
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
}



