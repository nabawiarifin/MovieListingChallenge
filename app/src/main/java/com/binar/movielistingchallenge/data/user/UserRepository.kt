package com.binar.movielistingchallenge.data.user

//Repository to access database for ViewModel
class UserRepository(private val registerDb: RegisterDatabase) {

    fun getUser(username: String, password: String) = registerDb.registerDAO().getUser(username,password)
}