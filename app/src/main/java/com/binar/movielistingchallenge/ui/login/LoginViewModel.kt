package com.binar.movielistingchallenge.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binar.movielistingchallenge.data.user.RegisterEntity
import com.binar.movielistingchallenge.data.user.UserRepository

class LoginViewModel(private val repository: UserRepository): ViewModel() {
//    private val _successGetUser = MutableLiveData<Boolean>()
//    val successGetUser: LiveData<Boolean>
//        get() = _successGetUser

    suspend fun getUser(username: String, password: String): RegisterEntity? {
        return repository.getUser(username, password)
    }


}