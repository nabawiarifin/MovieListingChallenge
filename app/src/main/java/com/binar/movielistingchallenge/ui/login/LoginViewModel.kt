package com.binar.movielistingchallenge.ui.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.binar.movielistingchallenge.data.user.RegisterEntity
import com.binar.movielistingchallenge.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: UserRepository): ViewModel() {

    suspend fun getUser(username: String, password: String): RegisterEntity {
        return repository.getUser(username, password)
    }


}