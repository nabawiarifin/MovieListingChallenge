package com.binar.movielistingchallenge.network.movies.network

import com.binar.movielistingchallenge.data.movies.MovieModel
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET("3/movie/popular?api_key=fa57017f542e2d465f41cd1e0be04aa9&language=en-US&page=1")
    fun getMovies(): Call<MovieModel>
}