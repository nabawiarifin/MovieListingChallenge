package com.binar.movielistingchallenge.data.movies.favourite

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "favourite_movies_table")
@Parcelize
data class FavouriteEntity (
    @PrimaryKey
    var id: Int?,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "date")
    var date: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "image")
    var image: String,

): Parcelable