package com.binar.movielistingchallenge.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.binar.movielistingchallenge.MainActivity
import com.binar.movielistingchallenge.R
import com.binar.movielistingchallenge.databinding.FragmentRegisterBinding
import com.binar.movielistingchallenge.user.database.RegisterDatabase
import com.binar.movielistingchallenge.user.database.RegisterEntity

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    var registerDb: RegisterDatabase? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerDb = RegisterDatabase.getInstance(MainActivity())

        binding.btnRegister.setOnClickListener {
            if (binding.etPasswordRegister == binding.etConfirmPasswordRegister) {
                val objectRegister = RegisterEntity(
                    id = null,
                    email = binding.etEmailRegister.text.toString(),
                    username = binding.etUsernameRegister.text.toString(),
                    password = binding.etPasswordRegister.text.toString()
                )

                Thread(Runnable {
                    val result = registerDb?.registerDAO()?.insertUser(objectRegister)
                    activity?.runOnUiThread {
                        if (result != 0.toLong()) {
                            Toast.makeText(
                                activity,
                                "Success adding ${objectRegister.username}",
                                Toast.LENGTH_LONG
                            ).show()

                        } else {
                            Toast.makeText(
                                activity,
                                "Failed adding ${objectRegister.username}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }).start()
            } else {
                Toast.makeText(activity,"Confirmation password not the same",Toast.LENGTH_SHORT).show()
            }
        }

        }

}