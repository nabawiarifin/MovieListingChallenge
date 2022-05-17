package com.binar.movielistingchallenge.ui.detail

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binar.movielistingchallenge.data.movies.favourite.FavouriteEntity
import com.binar.movielistingchallenge.data.user.RegisterEntity
import com.binar.movielistingchallenge.repositories.MoviesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: MoviesRepository): ViewModel() {
    //Coroutines
    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun addToFavourites(title: String, date: String, overview: String, image: String) {
        val objectMovie = FavouriteEntity(
            id = null,
            title = title,
            date = date,
            overview = overview,
            image = image
        )

        uiScope.launch {
            repository.insertFavouriteMovie(objectMovie)
        }
    }
}