package com.uni.unistudent.classes

import java.util.*


data class MyComments (
var commentID:String="",
    val description : String="",
    val authorName : String="",
    var myComment:Boolean=false,
    val time: Date = Date()
)