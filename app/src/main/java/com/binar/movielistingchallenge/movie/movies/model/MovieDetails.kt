package com.binar.movielistingchallenge.movie.movies.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetails (
    val title: String,
    val poster: String,
    val date: String,
    val overview: String
): Parcelable