package com.uni.unistudent.ui

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment

import com.uni.unistudent.databinding.ActivitySignUpBinding

import android.widget.*
import androidx.activity.viewModels
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.uni.unistudent.R

import com.uni.unistudent.viewModel.AuthViewModel
import com.uni.unistudent.viewModel.FireStorageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val viewModel : AuthViewModel by viewModels()

    companion object {
        const val IMAGE_REQUEST_CODE = 100
    }
     fun nextFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {

            setCustomAnimations(
                R.anim.enter_right_to_left,
                R.anim.exist_right_to_left,
                R.anim.enter_left_to_right,
                R.anim.exist_left_to_right
            )
            replace(
                R.id.fragment_container,
                fragment
            ).commit()
        }
    }
    fun previousFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {

            setCustomAnimations(
                R.anim.enter_left_to_right,
                R.anim.exist_left_to_right,
                R.anim.enter_right_to_left,
                R.anim.exist_right_to_left
            )

            replace(
                R.id.fragment_container,
                fragment
            ).commit()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nextFragment(FragmentSignUpMainData())

       // viewModel.logOut {  }
       // Log.e("Sign up","I am here")
    }
}