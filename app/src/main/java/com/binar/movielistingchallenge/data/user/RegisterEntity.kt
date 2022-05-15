package com.binar.movielistingchallenge.data.user

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "register_user_table")
@Parcelize
data class RegisterEntity (

    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @ColumnInfo(name = "email")
    var email: String,

    @ColumnInfo(name = "username")
    var username: String,

    @ColumnInfo(name = "password")
    var password: String

): Parcelable