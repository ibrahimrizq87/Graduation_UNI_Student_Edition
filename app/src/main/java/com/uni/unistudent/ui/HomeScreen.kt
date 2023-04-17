package com.uni.unistudent.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.uni.unistudent.R
import com.uni.unistudent.classes.user.UserStudent
import com.uni.unistudent.data.Resource
import com.uni.unistudent.databinding.ActivityHomeScreenBinding
import com.uni.unistudent.ui.fragments.*
import com.uni.unistudent.viewModel.AuthViewModel
import com.uni.unistudent.viewModel.FireStorageViewModel
import com.uni.unistudent.viewModel.FirebaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class HomeScreen : AppCompatActivity() {
    private val viewModel : AuthViewModel by viewModels()
    private val fireViewModel : FirebaseViewModel by viewModels()

    private val storageViewModel : FireStorageViewModel by viewModels()


    lateinit var currentUser:UserStudent

    private lateinit var binding: ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.attendance -> replaceFragment(AttendanceFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
                R.id.lectures -> {
                    replaceFragment(ScheduleFragment())
                    updateUser(currentUser)
                }
                else -> {
                }

            }
            true
        }

    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager=supportFragmentManager
        val fragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()

    }

private fun updateUser(user: UserStudent){
    viewModel.getUserStudent(user.userId,user.section,user.department,user.grade)
    }
private fun observeImage(){

    lifecycleScope.launchWhenCreated {
        storageViewModel.getUri.collectLatest { uri ->

            when (uri) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    Glide.with(this@HomeScreen)
                        .load(uri.result)
                        .into(binding.userImage)
                }
                is Resource.Failure -> {
                    Toast.makeText(this@HomeScreen,uri.exception.toString(),Toast.LENGTH_LONG).show()
                }
                else ->{
                }
            }
        }


    }
}

    private fun observeUser() {
        lifecycleScope.launchWhenCreated {
            viewModel.userStudent.collectLatest {state ->
                when (state) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        val user =state.result
                        if (user!=null){
                            viewModel.setSession(state.result)


                            binding.userGrade.text=user.grade
                            binding.userDepartement.text=user.department
                            binding.userName.text=user.name

                        }
                    }
                    is Resource.Failure -> {
                        Toast.makeText(this@HomeScreen,state.exception.toString(),Toast.LENGTH_LONG).show()
                    }
                    else ->{
                    }
                }
            }

        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getSessionStudent {user->
            if (user !=null){
                updateUser(user)
                currentUser=user
                storageViewModel.getUri(user.userId)
                observeUser()
                observeImage()
                if (user.hasPermission){
                    replaceFragment(HomeFragment())
                    binding.bottomNavigationView.visibility= View.VISIBLE

                }else{
                    replaceFragment(PermissionFragment())
                    binding.bottomNavigationView.visibility= View.INVISIBLE

                }

            }else{
                Toast.makeText(this,"no user found. have to register", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,SignUp::class.java))
            }
        }
    }


}