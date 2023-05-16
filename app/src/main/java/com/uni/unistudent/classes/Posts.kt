package com.uni.unistudent.classes

import android.net.Uri
import java.util.*

data class Posts (
    val description : String="",
    val authorName : String="",
    var postID:String="",
    var courseID:String="",
    val time: Date= Date(),
    val imageUrl: Uri? =null,
    val audience:String="",
    var type:Int=0
        )

// variable -> how can see?