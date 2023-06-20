package com.uni.unistudent.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.uni.unistudent.databinding.BottomSheetLayoutBinding


class BottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: BottomSheetLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetLayoutBinding.inflate(layoutInflater)

        binding.logOutBtn.setOnClickListener {
            Toast.makeText(context, "Log Out", Toast.LENGTH_SHORT).show()
        }


        return binding.root
    }


    companion object {
        const val TAG = "MyBottomSheetDialogFragment"
    }


}