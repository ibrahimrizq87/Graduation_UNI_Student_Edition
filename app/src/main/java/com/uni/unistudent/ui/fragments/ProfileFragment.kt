package com.uni.unistudent.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.uni.unistudent.R
import com.uni.unistudent.classes.Assistant
import com.uni.unistudent.classes.Courses
import com.uni.unistudent.classes.Professor
import com.uni.unistudent.classes.user.UserStudent
import com.uni.unistudent.data.Resource
import com.uni.unistudent.databinding.FragmentProfileBinding
import com.uni.unistudent.viewModel.AuthViewModel
import com.uni.unistudent.viewModel.FireStorageViewModel
import com.uni.unistudent.viewModel.FirebaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    lateinit var coursesList: MutableList<Courses>
    lateinit var lecturerList: MutableList<Professor>
    lateinit var assistantList: MutableList<Assistant>
    lateinit var currentUser: UserStudent
    private val viewModel: FirebaseViewModel by viewModels()
    private val authViewModel: AuthViewModel by viewModels()
    private val storageViewModel: FireStorageViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        coursesList = arrayListOf()
        lecturerList = arrayListOf()
        assistantList = arrayListOf()
        val binding = DataBindingUtil.inflate<FragmentProfileBinding>(
            inflater, R.layout.fragment_profile, container, false
        )
        authViewModel.getSessionStudent { user ->
            if (user != null) {
                currentUser = user
                binding.user = currentUser
                Toast.makeText(context, currentUser.name, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(
                    context,
                    getString(R.string.error_message_in_profile_screen),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
//TODO viewPager2 to view 3 lists lecturer , assistant and courses
        viewModel.getCourses(currentUser.grade)
        observeCourses()
        return binding.root

    }

    private fun observeCourses() {
        lifecycleScope.launchWhenCreated {
            viewModel.getCourses.collectLatest { state ->
                when (state) {
                    is Resource.Loading -> {
                        //  progress.visibility=View.VISIBLE

                    }

                    is Resource.Success -> {

                        state.result.forEach {
                            coursesList.add(it)
                        }
                        viewModel.getProfessor(coursesList)
                        viewModel.getAssistant(coursesList)
                        //  progress.visibility=View.VISIBLE
                        // ---------------------------- wait until the data is updated because of the delay done because of the loops---------------------//
                        delay(200)
                        // ---------------------------- wait until the data is updated because of the delay done because of the loops---------------------//
                        //   progress.visibility=View.INVISIBLE

                        observeLecturers()
                        observeAssistant()

                    }

                    is Resource.Failure -> {
                        // progress.visibility=View.INVISIBLE
                        Toast.makeText(context, state.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {}
                }
            }
        }
    }


    private fun observeAssistant() {
        lifecycleScope.launchWhenCreated {
            viewModel.getAssistant.collectLatest { state ->
                when (state) {
                    is Resource.Loading -> {
                        //progress.visibility=View.VISIBLE

                    }

                    is Resource.Success -> {
                        //progress.visibility=View.INVISIBLE

                        state.result.forEach {
                            assistantList.add(it)

                        }

                    }

                    is Resource.Failure -> {
                        // progress.visibility=View.INVISIBLE
                        Toast.makeText(context, state.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {}
                }
            }
        }

    }


    private fun observeLecturers() {
        lifecycleScope.launchWhenCreated {
            viewModel.getProfessor.collectLatest { state ->

                when (state) {
                    is Resource.Loading -> {
                        // progress.visibility=View.VISIBLE

                    }

                    is Resource.Success -> {
                        // progress.visibility=View.INVISIBLE
                        state.result.forEach {
                            lecturerList.add(it)
                        }
                    }

                    is Resource.Failure -> {
                        //  progress.visibility=View.INVISIBLE
                        Toast.makeText(context, state.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {}
                }
            }
        }
    }

}