package com.uni.unistudent.classes

import android.net.Uri
import java.util.*

data class Comment (
    var commentID:String="",
    var userID:String="",
    val description : String="",
    val authorName : String="",
    val authorCode : String="",
    val time: Date = Date()
    //TODO set user type for the comment
)