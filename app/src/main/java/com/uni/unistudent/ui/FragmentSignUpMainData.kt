package com.uni.unistudent.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.uni.unistudent.R
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

                val isEmailValid = isEmailValid(emailAddress)
                if (isEmailValid){

                    val isPassValid = isPasswordValid(password)
                    if (isPassValid) {
                    if (password == confirmPassword) {
                    if (nationalID.length == 14) {
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
                            requireContext(), R.string.passwordCheck,
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                } else {
                    Toast.makeText(
                        requireContext(), R.string.passwordNotMatch,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                    } else {
                        Toast.makeText(
                            requireContext(), R.string.invalid_password,
                            Toast.LENGTH_SHORT
                        ).show()
                    }


                }else{
                    Toast.makeText(
                        requireContext(), R.string.invalidEmail,
                        Toast.LENGTH_SHORT
                    ).show()

                }
            } else {
                Toast.makeText(requireContext(), R.string.alldata, Toast.LENGTH_SHORT).show()
            }

        }

        return binding.root
    }
    private fun isEmailValid(email: String): Boolean {
        val emailRegex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
        return emailRegex.matches(email)
    }

  private  fun isPasswordValid(password: String): Boolean {
        val uppercaseRegex = Regex(".*[A-Z].*")
        val numberRegex = Regex(".*\\d.*")
        return password.matches(uppercaseRegex) && password.matches(numberRegex)
    }

}