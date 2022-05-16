package com.binar.movielistingchallenge.data.user

//Repository to access database for ViewModel
class UserRepository(private val registerDAO: RegisterDAO) {

    suspend fun getUser(username: String, password: String): RegisterEntity {
        return registerDAO.getUser(username, password)
    }
}