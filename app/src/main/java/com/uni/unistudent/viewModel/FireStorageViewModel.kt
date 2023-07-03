package com.uni.unistudent.viewModel
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uni.unistudent.data.FireStorageRepo
import com.uni.unistudent.data.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FireStorageViewModel @Inject constructor(
    private val repository: FireStorageRepo
): ViewModel() {
    private val _getUri= MutableStateFlow<Resource<Uri>?>(null)
    val getUri=_getUri.asStateFlow()

    private val _addUri= MutableStateFlow<Resource<String>?>(null)
    val addUri=_addUri.asStateFlow()

    fun getUri(userId:String)= viewModelScope.launch{
        _getUri.value=Resource.Loading
        repository.downloadUri(userId) {
            _getUri.value=it
        }
    }
    fun addUri(userId:String,uri:Uri)= viewModelScope.launch{
        _addUri.value=Resource.Loading
        repository.uploadImage(uri,userId) {
            _addUri.value=it
        }
    }
    private val _getPostUri= MutableStateFlow<Resource<Uri>?>(null)
    val getPostUri=_getPostUri.asStateFlow()
    fun getPostUri(postId:String)= viewModelScope.launch{
        _getPostUri.value= Resource.Loading
        repository.downloadPostUri(postId) {
            _getPostUri.value=it
        }
    }
}