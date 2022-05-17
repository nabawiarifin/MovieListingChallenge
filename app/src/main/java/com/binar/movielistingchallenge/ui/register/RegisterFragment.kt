package com.binar.movielistingchallenge.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.binar.movielistingchallenge.databinding.FragmentRegisterBinding
import com.binar.movielistingchallenge.data.user.RegisterDatabase
import com.binar.movielistingchallenge.data.user.RegisterEntity
import com.binar.movielistingchallenge.repositories.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var registerDb: RegisterDatabase

    //Coroutines
    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        val registerDAO = RegisterDatabase.getInstance(requireContext()).registerDAO()
        val repository = UserRepository(registerDAO)
        val factory = RegisterViewModelFactory(repository)
        registerViewModel = ViewModelProvider(this, factory)[RegisterViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerDb = RegisterDatabase.getInstance(requireContext())

        binding.btnRegister.setOnClickListener {
            val email = binding.etEmailRegister.text.toString()
            val username = binding.etUsernameRegister.text.toString()
            val password = binding.etPasswordRegister.text.toString()
            val confirmPassword = binding.etConfirmPasswordRegister.text.toString()

            if (password == confirmPassword) {
                registerAccount(email, username, password)
            } else {
                Toast.makeText(activity, "Confirmation password not the same", Toast.LENGTH_SHORT)
                    .show()
            }
        }


    }

    private fun registerAccount(email: String, username: String, password: String) {
        //Takes user register input and saves it in list
        val objectRegister = RegisterEntity(
            id = null,
            email = email,
            username = username,
            password = password
        )

        uiScope.launch {
//            val result = registerDb.registerDAO().insertUser(objectRegister) //Inserts list to the database using insert User from DAO
            val result = registerViewModel.insertUser(objectRegister)
                if (result != 0.toLong()) {
                    Toast.makeText(activity, "Success adding ${objectRegister.username}", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(activity, "Failed adding ${objectRegister.username}", Toast.LENGTH_LONG).show()
                }

        }
    }
}