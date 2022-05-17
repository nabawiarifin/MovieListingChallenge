package com.binar.movielistingchallenge.ui.profile

import androidx.lifecycle.ViewModel
import com.binar.movielistingchallenge.data.user.RegisterEntity
import com.binar.movielistingchallenge.repositories.UserRepository

class ProfileViewModel(private val repository: UserRepository): ViewModel() {

//    suspend fun updateUser(registerEntity: RegisterEntity): Long {
//        return repository.updateUser(registerEntity)
//    }

    suspend fun getUser(username: String, password: String): RegisterEntity {
        return repository.getUser(username, password)
    }

}