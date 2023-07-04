package com.uni.unistudent.classes
data class ScheduleDataType(

    val eventId:String="",
    val courseName:String="",
    val courseID:String="",
    val hallID:String="",
    val section:String="",
    val dep:String="",
    val professorName:String="",
    val day:String="",
    val time:String="",
    val endTime:String="",
    val type:Int=0,
    val hasRunning:Boolean=false
)
