package com.uni.unistudent.ui

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

        binding.nextBtn.setOnClickListener{

            (activity as SignUp).replaceFragment(FragmentSignUpSubData())
        }
        return binding.root
    }


}