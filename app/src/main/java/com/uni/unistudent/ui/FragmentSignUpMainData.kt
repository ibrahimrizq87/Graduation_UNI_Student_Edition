package com.uni.unistudent.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.uni.unistudent.databinding.FragmentSignupMaindataBinding

class FragmentSignUpMainData : Fragment() {
    private lateinit var binding: FragmentSignupMaindataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupMaindataBinding.inflate(layoutInflater)

        binding.nextBtn.setOnClickListener {
            var name = binding.signName.text.trim()
            var nationalID = binding.signNationalId.text.trim()
            var emailAddress = binding.signEmailAddress.text.trim()
            var password = binding.signPassword.text.trim()
            var confirmPassword = binding.signConfirmPassword.text.trim()




            (activity as SignUp).nextFragment(FragmentSignUpSubData())
        }
        binding.signInTxt.setOnClickListener {
            activity?.finish()
        }
        return binding.root
    }


}