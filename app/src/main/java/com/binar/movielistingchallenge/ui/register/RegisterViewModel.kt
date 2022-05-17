package com.binar.movielistingchallenge.ui.register

import androidx.lifecycle.ViewModel
import com.binar.movielistingchallenge.data.user.RegisterEntity
import com.binar.movielistingchallenge.repositories.UserRepository

class RegisterViewModel(private val repository: UserRepository): ViewModel() {

    suspend fun insertUser(registerEntity: RegisterEntity): Long {
        return repository.insertUser(registerEntity)
    }
}