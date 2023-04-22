package com.uni.unistudent.data


import com.google.firebase.auth.FirebaseUser
import com.uni.unistudent.classes.Permission
import com.uni.unistudent.classes.user.UserStudent

interface AuthRepository {
    val user:FirebaseUser?
    suspend fun updateUserInfo(userTeaching: UserStudent, result:(Resource<String>) ->Unit)
    suspend fun register(email:String, password:String, userTeaching: UserStudent, result:(Resource<String>) -> Unit)
    suspend fun logOut(result:()->Unit)
    suspend fun addPermission(permission: Permission, result: (Resource<String>) -> Unit)
    fun storeSession(id :String, user :UserStudent, result :(UserStudent?)-> Unit)
    suspend fun getUserStudent(id :String,section:String,dep:String,grade:String, result:(Resource<UserStudent?>) -> Unit)
    fun getSessionStudent(result :(UserStudent?)-> Unit)
    fun setSession(user:UserStudent)


}