package com.uni.unistudent.classes

import android.net.Uri
import java.util.*

data class Comment (
    var commentID:String="",
    val description : String="",
    val authorName : String="",
    val time: Date = Date()
)