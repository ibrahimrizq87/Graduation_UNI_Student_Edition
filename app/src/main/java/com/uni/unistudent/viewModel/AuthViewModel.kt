package com.uni.unistudent.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.uni.unistudent.classes.user.UserStudent
import com.uni.unistudent.data.AuthRepository
import com.uni.unistudent.data.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val repository: AuthRepository):ViewModel() {

    private val _register = MutableStateFlow<Resource<String>?>(null)
    val register=_register.asStateFlow()


    private val _userStudent = MutableStateFlow<Resource<UserStudent?>?>(null)
    val userStudent=_userStudent.asStateFlow()

    val currentUser:FirebaseUser?
        get()=repository.user


    fun Register(email:String, password:String, user: UserStudent) = viewModelScope.launch {
      _register.value=Resource.Loading
      repository.register(email,password,user){
              _register.value=it
          }

    }
    fun getUserStudent(id :String,section:String,dep:String,grade:String)= viewModelScope.launch{
        _userStudent.value=Resource.Loading
        repository.getUserStudent(id,section,dep,grade){
            _userStudent.value=it
        }
    }

    fun setSession(user:UserStudent){
        repository.setSession(user)
    }
    fun logOut(result:()->Unit)= viewModelScope.launch {
        repository.logOut (result)
    }
fun getSessionStudent(result: (UserStudent?) -> Unit){
    repository.getSessionStudent(result)
}
}