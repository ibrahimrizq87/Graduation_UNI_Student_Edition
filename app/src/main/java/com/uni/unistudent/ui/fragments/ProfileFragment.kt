package com.uni.unistudent.ui.fragments

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.uni.unistudent.R
import com.uni.unistudent.adapters.ProfileAdapter
import com.uni.unistudent.classes.Assistant
import com.uni.unistudent.classes.Courses
import com.uni.unistudent.classes.Professor
import com.uni.unistudent.classes.user.UserStudent
import com.uni.unistudent.data.Resource
import com.uni.unistudent.data.di.SignUpKey
import com.uni.unistudent.databinding.FragmentProfileBinding
import com.uni.unistudent.ui.BottomSheetFragment
import com.uni.unistudent.ui.SignUp
import com.uni.unistudent.viewModel.AuthViewModel
import com.uni.unistudent.viewModel.FireStorageViewModel
import com.uni.unistudent.viewModel.FirebaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    private lateinit var bottomSheetFragment: BottomSheetFragment
    lateinit var coursesList: MutableList<Courses>
    lateinit var lecturerList: MutableList<Professor>
    lateinit var assistantList: MutableList<Assistant>
    lateinit var currentUser: UserStudent
    private val viewModel: FirebaseViewModel by viewModels()
    private val authViewModel: AuthViewModel by viewModels()
    private var isLecLoaded = false
    private var isAssLoaded = false
    private var isCorLoaded = false

    private val storageViewModel: FireStorageViewModel by viewModels()
    lateinit var testList: List<Courses>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        coursesList = arrayListOf()
        lecturerList = arrayListOf()
        assistantList = arrayListOf()
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_profile, container, false
        )

        authViewModel.getSessionStudent { user ->
            if (user != null) {
                currentUser = user
                binding.user = currentUser

                if (context?.let { checkForInternet(it) } == true) {
                    storageViewModel.getUri(user.userId)

                }
                observeImage()

            } else {
                Toast.makeText(
                    context,
                    getString(R.string.error_message_in_profile_screen),
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        viewModel.getCourses(currentUser.grade)
        observeCourses()

        binding.settingBtn.setOnClickListener { showBottomSheetSettings() }
        return binding.root
    }
    private fun showBottomSheetSettings() {
        bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.BottomSheetDialogTheme)
        bottomSheetFragment.isCancelable = true
        bottomSheetFragment.show(childFragmentManager, BottomSheetFragment.TAG)
    }
    private fun observeImage() {

        lifecycleScope.launchWhenCreated {
            storageViewModel.getUri.collectLatest { uri ->

                when (uri) {
                    is Resource.Loading -> {
                    }

                    is Resource.Success -> {
                        binding.progressBarImageProfile.visibility = View.GONE
                        Glide.with(this@ProfileFragment)
                            .load(uri.result)
                            //.diskCacheStrategy(DiskCacheStrategy.RESOURCE)  //TODO https://stackoverflow.com/questions/53140975/load-already-fetched-image-when-offline-in-glide-for-android
                            .placeholder(R.drawable.user_image)
                            .into(binding.imageProfile)
                    }

                    is Resource.Failure -> {
                        Toast.makeText(context, uri.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {
                    }
                }
            }


        }
    }
    private fun checkForInternet(context: Context): Boolean {

        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }

    private fun observeCourses() {
        lifecycleScope.launchWhenCreated {
            viewModel.getCourses.collectLatest { state ->
                when (state) {
                    is Resource.Loading -> {
                        binding.progressBarProfile.visibility = View.VISIBLE
                    }

                    is Resource.Success -> {
                        coursesList.clear()
                        state.result.forEach {
                            coursesList.add(it)
                        }
                        viewModel.getProfessor(coursesList)
                        viewModel.getAssistant(coursesList)
                        isCorLoaded = true
                        if (isAssLoaded && isLecLoaded) {
                            binding.progressBarProfile.visibility = View.GONE
                        }
                        // ---------------------------- wait until the data is updated because of the delay done because of the loops---------------------//
                        delay(200)
                        // ---------------------------- wait until the data is updated because of the delay done because of the loops---------------------//
                        //   progress.visibility=View.INVISIBLE
                        observeLecturers()
                        observeAssistant()
                        setRecycler(coursesList)
                    }

                    is Resource.Failure -> {
                        binding.progressBarProfile.visibility = View.GONE
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
                        binding.progressBarProfile.visibility = View.VISIBLE

                    }

                    is Resource.Success -> {
                        isAssLoaded = true
                        binding.progressBarProfile.visibility = View.GONE
                        if (isLecLoaded && isCorLoaded) {

                            binding.progressBarProfile.visibility = View.GONE

                        }
                        state.result.forEach {
                            assistantList.add(it)

                        }

                    }

                    is Resource.Failure -> {
                        binding.progressBarProfile.visibility = View.GONE
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
                        binding.progressBarProfile.visibility = View.VISIBLE

                    }

                    is Resource.Success -> {
                        isLecLoaded = true
                        if (isAssLoaded && isCorLoaded) {
                            binding.progressBarProfile.visibility = View.GONE
                        }
                        state.result.forEach {
                            lecturerList.add(it)
                        }
                    }

                    is Resource.Failure -> {
                        binding.progressBarProfile.visibility = View.GONE
                        Toast.makeText(context, state.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {}
                }
            }
        }
    }

    private fun setRecycler(list: List<Courses>) {

      //  Toast.makeText(context,   list[0].professor.toString(), Toast.LENGTH_SHORT).show()
        binding.recyclerCourses.adapter = ProfileAdapter(list)
        Log.i("Fofa", "actual list size : ${coursesList.size}")

    }
}