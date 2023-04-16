package com.uni.unistudent.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.uni.unistudent.R
import com.uni.unistudent.databinding.ActivityMainBinding
import com.uni.unistudent.viewModel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel : AuthViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signUp.setOnClickListener {
            startActivity(Intent(this,HomeScreen::class.java))
        }
        binding.logOut.setOnClickListener {
            viewModel.logOut {

            }
        }

    }
}