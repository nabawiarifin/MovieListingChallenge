package com.binar.movielistingchallenge.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.binar.movielistingchallenge.databinding.FragmentLoginBinding
import com.binar.movielistingchallenge.data.user.RegisterDatabase
import com.binar.movielistingchallenge.data.user.UserRepository
import com.binar.movielistingchallenge.ui.main.MovieViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding

    //Coroutine
    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        //Opens up database

        val registerDAO = RegisterDatabase.getInstance(requireContext()).registerDAO()
        val repository = UserRepository(registerDAO)
        val factory = LoginViewModelFactory(repository)
        loginViewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            //saves username and password from edittext
            val username = binding.etUsernameLogin.text.toString()
            val password = binding.etPasswordLogin.text.toString()

            //Checks if username or password edit text empty or not
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(activity, "Please insert login or password", Toast.LENGTH_SHORT)
                    .show()
                //Checks if username and password the same as in database
            } else {
                    uiScope.launch {
                    val result = loginViewModel.getUser(username, password) //opens up database
                        if (result != null) {
                            Toast.makeText(activity, "Login Successful", Toast.LENGTH_LONG).show()
                            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMainFragment(username)) // Goes to main page and sends username
                        } else {
                            Toast.makeText(
                                activity,
                                "Username or Password is not correct",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
        }

        binding.tvRegister.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
    }
}
