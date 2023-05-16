package com.uni.unistudent.viewModel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uni.unistudent.classes.*
import com.uni.unistudent.data.FirebaseRepo
import com.uni.unistudent.data.Resource
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirebaseViewModel @Inject constructor(
    private val  repository: FirebaseRepo

): ViewModel() {
//  https://stackoverflow.com/questions/72760708/kotlin-stateflow-not-emitting-updates-to-its-collectors
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

    //-----------------------------------------------------------------------------------------------------

    private val _getPostsPersonal= MutableStateFlow<Resource<List<Posts>>?>(null)
    val getPostsPersonal=_getPostsPersonal.asStateFlow()
    private val _getPostsGeneral= MutableStateFlow<Resource<List<Posts>>?>(null)
    val getPostsGeneral=_getPostsGeneral.asStateFlow()
    private val _getPostsSection= MutableStateFlow<Resource<List<Posts>>?>(null)
    val getPostsSection=_getPostsSection.asStateFlow()



    private val _getPostsCourse= MutableStateFlow<Resource<List<Posts>>?>(null)
    val getPostsCourse=_getPostsCourse.asStateFlow()




    private val _getPosts= MutableStateFlow<Resource<List<Posts>>?>(null)
    val getPosts=_getPosts.asStateFlow()
    fun getPosts(
        courses: List<Courses>,
        section: String,
        dep: String,
        userID: String
    ) = viewModelScope.launch{
        _getPosts.value=Resource.Loading
        repository.getPosts (courses,section,dep,userID){
            _getPosts.value=it

        }}


/*
    private val _addPostsPersonal= MutableStateFlow<Resource<String>?>(null)
    val addPostsPersonal=_getLecture.asStateFlow()
    private val _addPostsGeneral= MutableStateFlow<Resource<String>?>(null)
    val addPostsGeneral=_getLecture.asStateFlow()
    private val _addPostsSection= MutableStateFlow<Resource<String>?>(null)
    val addPostsSection=_getLecture.asStateFlow()
    private val _addPostsCourse= MutableStateFlow<Resource<String>?>(null)
    val addPostsCourse=_getLecture.asStateFlow()
    */

    //-----------------------------------------------------------------------------------------------------

   /* private val _getCommentPersonal= MutableStateFlow<Resource<List<Comment>>?>(null)
    val getCommentPersonal=_getCommentPersonal.asStateFlow()

    private val _getCommentSection= MutableStateFlow<Resource<List<Comment>>?>(null)
    val getCommentSection=_getCommentSection.asStateFlow()
    private val _getCommentCourse= MutableStateFlow<Resource<List<Comment>>?>(null)
    val getCommentCourse=_getCommentCourse.asStateFlow()
*/


    private val _getCommentGeneral= MutableStateFlow<Resource<List<Comment>>?>(null)
    val getCommentGeneral=_getCommentGeneral.asStateFlow()



    private val _addCommentGeneral= MutableStateFlow<Resource<String>?>(null)
    val addCommentGeneral=_addCommentGeneral.asStateFlow()




    /*private val _addCommentPersonal= MutableStateFlow<Resource<String>?>(null)
    val addCommentPersonal=_addCommentPersonal.asStateFlow()

    private val _addCommentSection= MutableStateFlow<Resource<String>?>(null)
    val addCommentSection=_addCommentSection.asStateFlow()
    private val _addCommentCourse= MutableStateFlow<Resource<String>?>(null)
    val addCommentCourse=_addCommentCourse.asStateFlow()
*/
    //-----------------------------------------------------------------------------------------------------




    fun getPostsPersonal(userId:String)= viewModelScope.launch{

        _getPostsPersonal.value=Resource.Loading
        repository.getPersonalPosts (userId){
            _getPostsPersonal.value=it

        }}
    fun getPostsGeneral()= viewModelScope.launch{

        _getPostsGeneral.value=Resource.Loading
        repository.getGeneralPosts (){
            _getPostsGeneral.value=it

        }}
    fun getPostsCourse(courses:List<Courses>)= viewModelScope.launch{

        _getPostsCourse.value=Resource.Loading
        repository.getCoursePosts (courses){
            _getPostsCourse.value=it

        }}
    fun getPostsSection(section:String,dep: String)= viewModelScope.launch{

        _getPostsSection.value=Resource.Loading
        repository.getSectionPosts (section,dep){
            _getPostsSection.value=it

        }}


    //---------------------------------------------------------------------------------------

    fun getCommentsPersonal(postID:String,userId:String)= viewModelScope.launch{

        _getCommentGeneral.value=Resource.Loading
        repository.getCommentPersonalPosts (postID ,userId){
            _getCommentGeneral.value=it

        }}
    fun getCommentsGeneral(postID:String)= viewModelScope.launch{

        _getCommentGeneral.value=Resource.Loading
        repository.getCommentGeneralPosts (postID ){
            _getCommentGeneral.value=it

        }}

    fun getCommentsSection(postID:String,section:String,dep:String)= viewModelScope.launch{

        _getCommentGeneral.value=Resource.Loading
        repository.getCommentSectionPosts (postID,section,dep ){
            _getCommentGeneral.value=it

        }}
    fun getCommentsCourse(postID:String,courseID: String)= viewModelScope.launch{

        _getCommentGeneral.value=Resource.Loading
        repository.getCommentCoursePosts (postID,courseID ){
            _getCommentGeneral.value=it

        }}
    /*
    fun getCommentsPersonal(postID:String,userId:String)= viewModelScope.launch{

        _getCommentPersonal.value=Resource.Loading
        repository.getCommentPersonalPosts (postID ,userId){
            _getCommentPersonal.value=it

        }}

    fun getCommentsGeneral(postID:String)= viewModelScope.launch{

        _getCommentGeneral.value=Resource.Loading
        repository.getCommentGeneralPosts (postID ){
            _getCommentGeneral.value=it

        }}

    fun getCommentsSection(postID:String,section:String,dep:String)= viewModelScope.launch{

        _getCommentSection.value=Resource.Loading
        repository.getCommentSectionPosts (postID,section,dep ){
            _getCommentSection.value=it

        }}
    fun getCommentsCourse(postID:String,courseID: String)= viewModelScope.launch{

        _getCommentCourse.value=Resource.Loading
        repository.getCommentCoursePosts (postID,courseID ){
            _getCommentCourse.value=it

        }}*/

    fun addCommentsPersonal(comment: Comment,postID:String,userId:String)= viewModelScope.launch{

        _addCommentGeneral.value=Resource.Loading
        repository.addCommentPersonalPosts (comment,postID ,userId){
            _addCommentGeneral.value=it

        }}
    fun addCommentsGeneral(comment: Comment,postID:String)= viewModelScope.launch{

        _addCommentGeneral.value=Resource.Loading
        repository.addCommentGeneralPosts (comment,postID ){
            _addCommentGeneral.value=it

        }}

    fun addCommentsSection(comment: Comment,postID:String,section:String,dep:String)= viewModelScope.launch{

        _addCommentGeneral.value=Resource.Loading
        repository.addCommentSectionPosts (comment,postID,section,dep ){
            _addCommentGeneral.value=it

        }}
    fun addCommentsCourse(comment: Comment,postID:String,courseID: String)= viewModelScope.launch{

        _addCommentGeneral.value=Resource.Loading
        repository.addCommentCoursePosts (comment,postID,courseID ){
            _addCommentGeneral.value=it

        }}



    fun getPermission(userId:String)= viewModelScope.launch{

        _getPermission.value=Resource.Loading
        repository.getPermission (userId){
            _getPermission.value=it

        }}
    fun getCourses(grade:String)= viewModelScope.launch{
        _getCourses.value=Resource.Loading
        repository.getCourse (grade){
            _getCourses.value=it
        }}
    fun getLecture(courses:List<Courses>,dep:String){

        repository.getLectures(courses,dep) {
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
