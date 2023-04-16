package com.uni.unistudent.data

import com.uni.unistudent.classes.*
import kotlinx.coroutines.flow.Flow


interface FirebaseRepo {
    suspend fun getAssistant(courses: List<Courses>, result: (Resource<List<Assistant>>) -> Unit)

    suspend fun getProfessor(courses: List<Courses>, result: (Resource<List<Professor>>) -> Unit)
    suspend fun getPermission(userId:String,result: (Resource<Permission?>) -> Unit)
    suspend fun getSection(courses: List<Courses>, dep :String,section:String, result: (Resource<List<Section>>) -> Unit)
    fun getLectures2(courses: List<Courses>,dep:String, result: (List<Lecture>?) -> Unit)
     fun getLectures(courses: List<Courses>,dep:String, result: (Resource<List<Lecture>>) -> Unit)
    suspend fun getCourseByAssistantCode( assistantCode:String,result: (Resource<List<Courses>>) -> Unit)
    suspend fun  getCourseByProfessorCode( professorCode:String,result: (Resource<List<Courses>>) -> Unit)
    suspend fun getCourse( grade: String,result: (Resource<List<Courses>>) -> Unit)
     suspend fun updateSectionAttendance(attendance: Attendance, sectionId: String, result: (Resource<String>) -> Unit)
     suspend fun updateLectureAttendance(attendance: Attendance, lectureId: String, result: (Resource<String>) -> Unit)


}