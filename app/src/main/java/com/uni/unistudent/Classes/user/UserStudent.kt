package com.uni.unistudent.Classes.user

import com.uni.unistudent.data.di.UserTypes


data class UserStudent (
    var name: String="",
    var userId: String="",
    val code: String="",
    val nationalId: String="",
    val grade :String = "",
    var section:String="",
    var department:String="",
    var hasPermission:Boolean=false



)