package com.binar.movielistingchallenge.network

import android.graphics.Movie
import com.binar.movielistingchallenge.model.MovieModel
import com.binar.movielistingchallenge.model.Movies
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//Binar
//interface MovieApiInterface {
//    @GET("3/movie/popular?api_key=fa57017f542e2d465f41cd1e0be04aa9&language=en-US&page=1")
//    fun getMovies(): Call<List<Movies>>
//}

//Andre
interface MovieApiInterface {
    @GET("3/movie/popular?api_key=fa57017f542e2d465f41cd1e0be04aa9&language=en-US&page=1")
    fun getMovies(): Call<MovieModel>
}