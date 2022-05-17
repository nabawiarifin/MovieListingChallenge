package com.binar.movielistingchallenge.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.binar.movielistingchallenge.data.movies.Movies
import com.binar.movielistingchallenge.repositories.MoviesRepository

class MovieViewModel(private val repository: MoviesRepository) : ViewModel() {

    fun getMovies(): LiveData<List<Movies>>{
        return repository.movies
    }



}



