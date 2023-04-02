package com.uni.unistudent.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uni.unistudent.R
import com.uni.unistudent.databinding.ActivityHomeScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeScreen : AppCompatActivity() {
    private lateinit var binding: ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}