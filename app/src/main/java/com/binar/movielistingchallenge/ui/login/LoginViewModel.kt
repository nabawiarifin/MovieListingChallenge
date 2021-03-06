package com.binar.movielistingchallenge.ui.login

import androidx.lifecycle.ViewModel
import com.binar.movielistingchallenge.data.user.RegisterEntity
import com.binar.movielistingchallenge.repositories.UserRepository

class LoginViewModel(private val repository: UserRepository): ViewModel() {

    suspend fun getUser(username: String, password: String): RegisterEntity {
        return repository.getUser(username, password)
    }


}