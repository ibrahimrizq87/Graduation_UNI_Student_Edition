package com.uni.unistudent.ui

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
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
    private lateinit var backData: Bundle


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSignupMaindataBinding.inflate(layoutInflater)
        backData = bundleOf()
        name = ""
        nationalID = ""
        emailAddress = ""
        password = ""
        confirmPassword = ""

        parentFragmentManager.setFragmentResultListener(
            SignUpKey.BACK_DATA, this
        ) { _, result ->

            backData = result
            if (!result.isEmpty) {
                binding.signName.setText(backData.getString("name").toString())
                binding.signEmailAddress.setText(backData.getString("emailAddress").toString())
                binding.signConfirmPassword.setText(backData.getString("password").toString())
                binding.signPassword.setText(backData.getString("password").toString())
                binding.signNationalId.setText(backData.getString("nationalID").toString())
            }
        }

        binding.nextBtn.setOnClickListener {
            name = binding.signName.text.trim().toString()
            nationalID = binding.signNationalId.text.trim().toString()
            emailAddress = binding.signEmailAddress.text.trim().toString()
            password = binding.signPassword.text.trim().toString()
            confirmPassword = binding.signConfirmPassword.text.trim().toString()



            if (emailAddress.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty() && nationalID.isNotEmpty() && name.isNotEmpty()) {

                val isEmailValid = isEmailValid(emailAddress)
                if (isEmailValid) {

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
                                showTopSnackBar(binding.root, R.string.passwordCheck)
                            }
                        } else {
                            showTopSnackBar(binding.root, R.string.passwordNotMatch)
                        }
                    } else {
                        showTopSnackBar(binding.root, R.string.invalid_password)
                    }
                } else {
                    showTopSnackBar(binding.root, R.string.invalidEmail)
                }
            } else {
                showTopSnackBar(binding.root, R.string.alldata)
            }

        }

        return binding.root
    }

    private fun isEmailValid(email: String): Boolean {
        val emailRegex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
        return emailRegex.matches(email)
    }

    private fun isPasswordValid(password: String): Boolean {
        val uppercaseRegex = Regex(".*[A-Z].*")
        val numberRegex = Regex(".*\\d.*")
        return password.matches(uppercaseRegex) && password.matches(numberRegex)
    }

    private fun showTopSnackBar(view: View, message: Int) {
        val snackBar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)

        val slideInAnimation = AnimationUtils.loadAnimation(view.context, R.anim.slide_in_top)
        val slideOutAnimation = AnimationUtils.loadAnimation(view.context, R.anim.slide_out_bottom)

        snackBar.view.animation = slideInAnimation
        snackBar.addCallback(object : Snackbar.Callback() {
            override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                snackBar.view.animation = slideOutAnimation
            }
        })


        val params = snackBar.view.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
        //  params.setMargins(10,10,10,10)
        snackBar.view.layoutParams = params
        snackBar.show()
    }
}