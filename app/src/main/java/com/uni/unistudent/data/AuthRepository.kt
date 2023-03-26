package com.uni.unistudent.data


import com.google.firebase.auth.FirebaseUser
import com.uni.unistudent.Classes.Permission
import com.uni.unistudent.Classes.user.UserStudent

interface AuthRepository {
    suspend fun updateUserInfo(userStudent: UserStudent, result:(Resource<String>) ->Unit)
    suspend fun register(email:String, password:String, userStudent: UserStudent, result:(Resource<String>) -> Unit)
    suspend fun logOut(result:()->Unit)
    fun storeSession(id :String,user :UserStudent,result :(UserStudent?)-> Unit)
    suspend fun getUserStudent(id :String,section:String,dep:String,grade:String, result:(Resource<UserStudent?>) -> Unit)
    fun getSessionStudent(result :(UserStudent?)-> Unit)
    fun setSession(user:UserStudent)


}