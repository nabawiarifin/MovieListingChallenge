package com.binar.movielistingchallenge.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.binar.movielistingchallenge.databinding.FragmentRegisterBinding
import com.binar.movielistingchallenge.data.user.RegisterDatabase
import com.binar.movielistingchallenge.data.user.RegisterEntity

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container,false)
        return binding.root
    }

    var registerDb: RegisterDatabase? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerDb = RegisterDatabase.getInstance(requireContext())

        var password = binding.etPasswordRegister.text.toString()
        var confirmPassword = binding.etConfirmPasswordRegister.text.toString()

        binding.btnRegister.setOnClickListener {
            if (password == confirmPassword) {

                //Takes user register input and saves it in list
                val objectRegister = RegisterEntity(
                    id = null,
                    email = binding.etEmailRegister.text.toString(),
                    username = binding.etUsernameRegister.text.toString(),
                    password = binding.etPasswordRegister.text.toString()
                )

                Thread(Runnable {
                    val result = registerDb?.registerDAO()?.insertUser(objectRegister) //Inserts list to the database using inserUser from DAO
                    activity?.runOnUiThread {
                        if (result != 0.toLong()) {
                            Toast.makeText(activity, "Success adding ${objectRegister.username}", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(activity, "Failed adding ${objectRegister.username}", Toast.LENGTH_LONG).show()
                        }
                    }
                }).start()
            } else {
                Toast.makeText(activity,"Confirmation password not the same",Toast.LENGTH_SHORT).show()
            }
        }

        }

}