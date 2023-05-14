package com.uni.unistudent.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.uni.unistudent.data.di.SignUpKey
import com.uni.unistudent.databinding.FragmentSignupMaindataBinding

class FragmentSignUpMainData : Fragment() {
    private lateinit var binding: FragmentSignupMaindataBinding
    private lateinit var name: String
    private lateinit var nationalID: String
    private lateinit var emailAddress: String
    private lateinit var password: String
    private lateinit var confirmPassword: String


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupMaindataBinding.inflate(layoutInflater)

        binding.nextBtn.setOnClickListener {
            name = binding.signName.text.trim().toString()
            nationalID = binding.signNationalId.text.trim().toString()
            emailAddress = binding.signEmailAddress.text.trim().toString()
            password = binding.signPassword.text.trim().toString()
            confirmPassword = binding.signConfirmPassword.text.trim().toString()



            if (emailAddress.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty() && nationalID.isNotEmpty() && name.isNotEmpty()) {
                if (password == confirmPassword) {
                    if (password.length == 14) {
                        var bundle: Bundle = bundleOf()

                        bundle.putString("name", name)
                        bundle.putString("nationalID", nationalID)
                        bundle.putString("emailAddress", emailAddress)
                        bundle.putString("password", password)
                        bundle.putString("confirmPassword", confirmPassword)
                        parentFragmentManager.setFragmentResult(SignUpKey.MAIN_DATA, bundle)
                        (activity as SignUp).nextFragment(FragmentSignUpSubData())

                    } else {
                        Toast.makeText(
                            requireContext(), "make sure to write the 14 number of the national id",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                } else {
                    Toast.makeText(
                        requireContext(), "password not match!",
                        Toast.LENGTH_SHORT
                    ).show()
                }


            } else {
                Toast.makeText(requireContext(), "all data are required", Toast.LENGTH_SHORT).show()

            }



        }

        return binding.root
    }


}