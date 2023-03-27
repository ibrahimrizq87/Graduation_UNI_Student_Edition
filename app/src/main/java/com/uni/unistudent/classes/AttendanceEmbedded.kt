package com.uni.unistudent.classes

import java.util.*

data class AttendanceEmbedded (
    val id : String="",
    val state:Boolean=false,
    val time: Date = Date()
)