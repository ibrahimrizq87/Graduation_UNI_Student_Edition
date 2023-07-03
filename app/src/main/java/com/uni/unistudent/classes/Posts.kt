package com.uni.unistudent.classes

import android.net.Uri
import java.util.*

data class Posts (
    val description : String="",
    val authorName : String="",
    var postID:String="",
    var courseID:String="",
    val time: Date= Date(),
    var imageUrl: Uri =Uri.EMPTY,
    val audience:String="",
    var type:Int=0
        )

// variable -> how can see?