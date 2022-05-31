package com.binar.movielistingchallenge.ui.register

import androidx.lifecycle.ViewModel
import com.binar.movielistingchallenge.data.user.RegisterEntity
import com.binar.movielistingchallenge.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: UserRepository): ViewModel() {

    suspend fun insertUser(registerEntity: RegisterEntity): Long {
        return repository.insertUser(registerEntity)
    }
}