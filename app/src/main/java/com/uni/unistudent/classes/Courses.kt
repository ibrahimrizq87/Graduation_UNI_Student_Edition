package com.uni.unistudent.classes

import com.google.firebase.firestore.model.Document

data class Courses (
    val courseName:String ="",
    val courseCode:String="",
    val grade : String="",
    //todo i need here get collection of professor in fireBase
    val professor:String="",
    val learningAssistant:String=""
    )