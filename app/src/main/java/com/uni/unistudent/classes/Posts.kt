package com.uni.unistudent.classes

import android.net.Uri
import java.util.*

data class Posts (
    val description : String="",
    val authorName : String="",
    var postID:String="",
    val time: Date= Date(),
    val hasImage: Boolean =false,
    val audience:String="",
    var type:Int=0
        )

// variable -> how can see?