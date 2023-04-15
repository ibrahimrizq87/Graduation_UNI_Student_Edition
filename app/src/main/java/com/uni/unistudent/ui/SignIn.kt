package com.uni.unistudent.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uni.unistudent.databinding.ActivitySignInBinding

class SignIn : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.signUpTxt.setOnClickListener {
            startActivity(Intent(this@SignIn, SignUp::class.java))
        }

        val email = binding.email.text.trim()
        val password = binding.pass.text.trim()

        binding.signIn.setOnClickListener{

        }
    }
}