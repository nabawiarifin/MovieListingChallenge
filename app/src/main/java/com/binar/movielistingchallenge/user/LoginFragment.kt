package com.binar.movielistingchallenge.user

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.binar.movielistingchallenge.MainActivity
import com.binar.movielistingchallenge.R
import com.binar.movielistingchallenge.databinding.FragmentLoginBinding
import com.binar.movielistingchallenge.user.database.RegisterDAO
import com.binar.movielistingchallenge.user.database.RegisterDatabase

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    var registerDb: RegisterDatabase? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Opens up database
        registerDb = RegisterDatabase.getInstance(requireContext())

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
                Thread(Runnable {
                    val result = registerDb?.registerDAO()?.getUser(username, password) //opens up database
                    activity?.runOnUiThread {
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
                }).start()
            }

            binding.tvRegister.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
            }
        }
    }
}
