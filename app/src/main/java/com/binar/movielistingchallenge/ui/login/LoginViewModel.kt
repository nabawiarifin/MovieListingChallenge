package com.binar.movielistingchallenge.ui.login

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.binar.movielistingchallenge.data.user.RegisterDatabase
import com.binar.movielistingchallenge.data.user.UserRepository

class LoginViewModel(private val repository: UserRepository): ViewModel() {

    private val _successGetUser = MutableLiveData<Boolean>()
    val successGetUser: LiveData<Boolean>
        get() = _successGetUser

    fun getUser(username: String, password: String) {
        Thread(Runnable {
            val result = repository.getUser(username, password) //opens up database
            if (result != null) {
                _successGetUser.value = true
            }
        }).start()

    }


}