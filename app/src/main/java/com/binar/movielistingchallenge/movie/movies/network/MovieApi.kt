package com.binar.movielistingchallenge.movie.movies.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl("https://api.themoviedb.org/")
    .build()

object MovieApi {
    val retrofitService: MovieApiInterface by lazy { retrofit.create(MovieApiInterface::class.java)}
}