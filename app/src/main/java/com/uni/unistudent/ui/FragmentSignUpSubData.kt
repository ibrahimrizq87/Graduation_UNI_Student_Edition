package com.uni.unistudent.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.uni.unistudent.databinding.FragmentSignupSubdataBinding

class FragmentSignUpSubData:Fragment() {
    private lateinit var binding: FragmentSignupSubdataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupSubdataBinding.inflate(layoutInflater)

        return binding.root
    }
}