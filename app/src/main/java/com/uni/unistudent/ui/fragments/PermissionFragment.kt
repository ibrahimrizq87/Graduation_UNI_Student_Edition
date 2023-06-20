package com.uni.unistudent.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.uni.unistudent.R
import com.uni.unistudent.data.Resource
import com.uni.unistudent.viewModel.FirebaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class PermissionFragment : Fragment() {

    private val viewModel: FirebaseViewModel by viewModels()

    private lateinit var permissionText: TextView
    private lateinit var user: FirebaseUser

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        user = FirebaseAuth.getInstance().currentUser!!
        viewModel.getPermission(user.uid)
        observePermission()


        return inflater.inflate(R.layout.fragment_permission, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        permissionText = view.findViewById(R.id.permission_text)

    }
    private fun observePermission() {


        lifecycleScope.launchWhenCreated {
            viewModel.getPermission.collectLatest { state ->

                when (state) {
                    is Resource.Loading -> {
                    }

                    is Resource.Success -> {
                        permissionText.text = state.result?.permissionMessage
                    }

                    is Resource.Failure -> {
                        Toast.makeText(context, state.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {
                    }
                }
            }
        }
    }


}