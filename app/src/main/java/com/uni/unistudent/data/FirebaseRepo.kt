package com.uni.unistudent.data

import com.uni.unistudent.classes.*
import kotlinx.coroutines.flow.Flow


interface FirebaseRepo {
    suspend fun deleteCommentGeneralPosts(
        comment: Comment,
        postID: String,
        result: (Resource<String>) -> Unit
    )
    suspend fun deleteCommentSectionPosts(
        comment: Comment,
        postID: String,
        section: String,
        dep: String,

        result: (Resource<String>) -> Unit
    )
    suspend fun deleteCommentPersonalPosts(
        comment: Comment,
        postID: String,
        userID: String,
        result: (Resource<String>) -> Unit
    )
    suspend fun deleteCommentCoursePosts(
        comment: Comment,
        postID: String,
        courseID: String,
        result: (Resource<String>) -> Unit
    )
     suspend fun updateCommentGeneralPosts(
        comment: Comment,
        postID: String,
        result: (Resource<String>) -> Unit
    )
     suspend fun updateCommentSectionPosts(
        comment: Comment,
        postID: String,
        section: String,
        dep: String,

        result: (Resource<String>) -> Unit
    )
     suspend fun updateCommentCoursePosts(
        comment: Comment,
        postID: String,
        courseID: String,
        result: (Resource<String>) -> Unit
    )
     suspend fun updateCommentPersonalPosts(
        comment: Comment,
        postID: String,
        userID: String,
        result: (Resource<String>) -> Unit
    )
    suspend fun getAssistant(courses: List<Courses>, result: (Resource<List<Assistant>>) -> Unit)
    suspend fun getGeneralPosts( result: (Resource<List<Posts>>) -> Unit)
    suspend fun getSectionPosts( section:String,dep:String, result: (Resource<List<Posts>>) -> Unit)
    suspend fun getCoursePosts(courses: List<Courses>, result: (Resource<List<Posts>>) -> Unit)
    suspend fun getPersonalPosts(userID:String, result: (Resource<List<Posts>>) -> Unit)

    suspend fun getPosts(
        courses: List<Courses>,
        section: String,
        dep: String,
        userID: String,
        result: (Resource<List<Posts>>) -> Unit
    )
    suspend fun addCommentGeneralPosts(comment: Comment, postID:String,result: (Resource<String>) -> Unit)
    suspend fun addCommentSectionPosts(comment: Comment,postID:String, section:String,dep:String, result: (Resource<String>) -> Unit)
    suspend fun addCommentCoursePosts(comment: Comment,postID:String,courseID:String, result: (Resource<String>) -> Unit)
    suspend fun addCommentPersonalPosts(comment: Comment,postID:String,userID:String, result: (Resource<String>) -> Unit)



    suspend fun getCommentGeneralPosts( postID:String,result: (Resource<List<Comment>>) -> Unit)
    suspend fun getCommentSectionPosts(postID:String, section:String,dep:String, result: (Resource<List<Comment>>) -> Unit)
    suspend fun getCommentCoursePosts(postID:String,courseID:String, result: (Resource<List<Comment>>)-> Unit)
    suspend fun getCommentPersonalPosts(postID:String,userID:String, result:(Resource<List<Comment>>) -> Unit)





    suspend fun getProfessor(courses: List<Courses>, result: (Resource<List<Professor>>) -> Unit)
    suspend fun getPermission(userId:String,result: (Resource<Permission?>) -> Unit)
    suspend fun getSection(courses: List<Courses>, dep :String,section:String, result: (Resource<List<Section>>) -> Unit)
    fun getLectures2(courses: List<Courses>,dep:String, result: (List<Lecture>?) -> Unit)
     fun getLectures(courses: List<Courses>,dep:String, result: (Resource<List<Lecture>>) -> Unit)
    suspend fun getCourseByAssistantCode( assistantCode:String,result: (Resource<List<Courses>>) -> Unit)
    suspend fun  getCourseByProfessorCode( professorCode:String,result: (Resource<List<Courses>>) -> Unit)
    suspend fun getCourse( grade: String,result: (Resource<List<Courses>>) -> Unit)
    suspend fun updateSectionAttendance(
        attendance: Attendance,
        section: Section,
        result: (Resource<String>) -> Unit
    )
        suspend fun updateLectureAttendance(
        attendance: Attendance,
        lecture: Lecture,
        result: (Resource<String>) -> Unit
    )


}