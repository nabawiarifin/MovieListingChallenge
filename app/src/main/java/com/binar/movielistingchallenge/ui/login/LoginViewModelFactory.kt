package com.binar.movielistingchallenge.ui.login

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.binar.movielistingchallenge.data.user.UserRepository
import java.lang.IllegalArgumentException

class LoginViewModelFactory(private val repository: UserRepository): ViewModelProvider.NewInstanceFactory() {
    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}