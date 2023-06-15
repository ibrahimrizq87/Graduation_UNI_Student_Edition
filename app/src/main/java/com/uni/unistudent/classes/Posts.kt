package com.uni.unistudent.classes

import android.net.Uri
import java.util.*

data class Posts (
    val description : String="",
    val authorName : String="",
    var postID:String="",
    var courseID:String="",
    val time: Date= Date(),
    val imageUrl: Uri? =null, // TODO remove the uri and get the picture from the id of the post
    val audience:String="",
    var type:Int=0
        )

// variable -> how can see?