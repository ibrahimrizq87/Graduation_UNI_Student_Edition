package com.uni.unistudent.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.fragment.app.Fragment

import com.uni.unistudent.databinding.FragmentSignupSubdataBinding

class FragmentSignUpSubData : Fragment() {
    private lateinit var binding: FragmentSignupSubdataBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupSubdataBinding.inflate(layoutInflater)


        binding.signUpBtn.setOnClickListener {

            var code = binding.signCode.text.trim()
            var userImage = binding.signUserImage
            var section = binding.sectionTxt.text.trim()
            var department = binding.departmentTxt.text.trim()
            var grade = binding.gradeTxt.text.trim()
        }

        binding.backBtn.setOnClickListener {
            (activity as SignUp).previousFragment(FragmentSignUpMainData())
        }
        binding.signIn.setOnClickListener {
            activity?.finish()
        }
        return binding.root
    }
}