package com.binar.movielistingchallenge.repositories

import com.binar.movielistingchallenge.data.user.RegisterDAO
import com.binar.movielistingchallenge.data.user.RegisterEntity
import javax.inject.Inject

//Repository to access database for ViewModel
class UserRepository @Inject constructor(private val registerDAO: RegisterDAO) {

    suspend fun getUser(username: String, password: String): RegisterEntity {
        return registerDAO.getUser(username, password)
    }

    suspend fun insertUser(registerEntity: RegisterEntity): Long {
        return registerDAO.insertUser(registerEntity)
    }

//    suspend fun updateUser(registerEntity: RegisterEntity): Long {
//        return registerDAO.updateUser(registerEntity)
//    }
}