package com.binar.movielistingchallenge.user

import android.os.Bundle
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
    private lateinit var dao: RegisterDAO

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    var registerDb: RegisterDatabase? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerDb = RegisterDatabase.getInstance(MainActivity())

        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment) // Goes to homepage
        }
    }
}
