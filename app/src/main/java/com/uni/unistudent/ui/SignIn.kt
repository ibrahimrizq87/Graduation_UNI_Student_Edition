package com.uni.unistudent.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uni.unistudent.databinding.ActivitySignInBinding

class SignIn : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}