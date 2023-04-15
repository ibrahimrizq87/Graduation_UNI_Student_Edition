package com.uni.unistudent.viewModel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uni.unistudent.classes.*
import com.uni.unistudent.data.FirebaseRepo
import com.uni.unistudent.data.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirebaseViewModel @Inject constructor(
    private val  repository: FirebaseRepo
): ViewModel() {

    private val _getCourses= MutableStateFlow<Resource<List<Courses>>?>(null)
    val getCourses=_getCourses.asStateFlow()
    private val _getPermission= MutableStateFlow<Resource<Permission?>?>(null)
    val getPermission=_getPermission.asStateFlow()


    private val _getProfessor= MutableStateFlow<Resource<List<Professor>>?>(null)
    val getProfessor=_getProfessor.asStateFlow()
    private val _getAssistant= MutableStateFlow<Resource<List<Assistant>>?>(null)
    val getAssistant=_getAssistant.asStateFlow()
    private val _getSection= MutableStateFlow<Resource<List<Section>>?>(Resource.Loading)
    val getSection=_getSection.asStateFlow()
    private val _getLecture= MutableStateFlow<Resource<List<Lecture>>?>(null)
    val getLecture=_getLecture.asStateFlow()


    fun getPermission(userId:String){
        viewModelScope.launch(Dispatchers.IO){
        _getPermission.value=Resource.Loading
        repository.getPermission (userId){
            _getPermission.value=it
        }
        }}
    fun getCourses(grade:String)= viewModelScope.launch{
        _getCourses.value=Resource.Loading
        repository.getCourse (grade){
            _getCourses.value=it
        }}
    fun getLecture(courses:List<Courses>,dep:String){
        _getLecture.value=Resource.Loading
        repository.getLectures(courses,dep) {
            Log.e("view model", _getLecture.toString())
            _getLecture.value=it
        }}
    fun getSection(courses:List<Courses>,dep: String,section: String)= viewModelScope.launch{
        _getSection.value=Resource.Loading
        repository.getSection(courses,dep,section) {
            _getSection.value=it
        }}
    fun getProfessor(courses:List<Courses>)= viewModelScope.launch{
        _getProfessor.value=Resource.Loading
        repository.getProfessor(courses) {
            _getProfessor.value=it
        }}
    fun getAssistant(courses:List<Courses>)= viewModelScope.launch{
        _getAssistant.value=Resource.Loading
        repository.getAssistant(courses) {
            _getAssistant.value=it
        }}
     }
