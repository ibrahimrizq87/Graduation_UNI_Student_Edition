package com.uni.unistudent.classes.user



data class UserStudent (
    var name: String="",
    var userId: String="",
    val code: String="",
    val nationalId: String="",
    val grade :String = "",
    var section:String="",
    var department:String="",
    var hasPermission:Boolean = false



)