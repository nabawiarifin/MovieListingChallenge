package com.binar.movielistingchallenge.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl("https://api.themoviedb.org/")
    .build()

object MovieApi {
    val retrofitService:MovieApiInterface by lazy {retrofit.create(MovieApiInterface::class.java)}
}