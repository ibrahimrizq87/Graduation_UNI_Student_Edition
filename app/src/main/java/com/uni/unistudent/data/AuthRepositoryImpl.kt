package com.uni.unistudent.data

import android.content.SharedPreferences

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.uni.unistudent.classes.Permission
import com.uni.unistudent.classes.user.UserStudent
import com.uni.unistudent.data.di.PermissionsRequired
import com.uni.unistudent.data.di.SharedPreferencesTable
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthRepositoryImpl@Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val database:FirebaseFirestore,
    private val appPreferences: SharedPreferences,
    private val gson:Gson
) : AuthRepository {

    override suspend fun updateUserInfo(userStudent: UserStudent, result: (Resource<String>) ->Unit ) {
            val document=database.collection(userStudent.grade)
                .document(userStudent.department)
                .collection(userStudent.section)
                .document(userStudent.userId)
            document.set(userStudent)
                .addOnSuccessListener {
                    result.invoke(
                        Resource.Success("user date updated successfully")
                    )
                }
                .addOnFailureListener{
                    result.invoke(
                        Resource.Failure(
                            it.localizedMessage
                        )
                    )
                }

    }

    override val user:FirebaseUser?
    get() =firebaseAuth.currentUser

    override suspend fun register(
        email: String,
        password: String,
        userStudent: UserStudent,
        result: (Resource<String>) -> Unit
    ) {
        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener{
                if (it.isSuccessful){
                    GlobalScope.launch {
                        val userId=it.result.user?.uid?:""
                        userStudent.userId=userId
                        updateUserInfo(userStudent){ state->
                            when(state){
                                Resource.Loading -> result.invoke(Resource.Loading)
                                is Resource.Success-> {
                                    storeSession(userId,userStudent) { user->
                                        if (user == null) {
                                            result.invoke(Resource.Failure("user created successfully but session did not stored"))
                                        } else {

                                            GlobalScope.launch {
                                                addPermission(Permission(PermissionsRequired.sing_in_permission,userId,"")){
                                            when(it){
                                                Resource.Loading -> result.invoke(Resource.Loading)
                                                is Resource.Failure -> {result.invoke(Resource.Success("user created successfully but you need to check you permission with admin"))}
                                                is Resource.Success -> {result.invoke(Resource.Success("user created successfully"))}
                                            }
                                                }
                                            }
                                        }
                                    }

                                }is Resource.Failure->{result.invoke(Resource.Failure(state.exception))}


                            }
                        }

                    }
                }else{
                    result.invoke(
                        Resource.Failure(
                            it.exception.toString()
                        )
                    )
                }
            }
            .addOnFailureListener {
                result.invoke(
                    Resource.Failure(
                        it.localizedMessage
                    )
                )
            }

    }

    override suspend fun logOut(result: () -> Unit) {
        firebaseAuth.signOut()
        result.invoke()
        appPreferences.edit().putString(SharedPreferencesTable.user_session,null).apply()

    }


    override fun storeSession(id :String,user :UserStudent,result :(UserStudent?)-> Unit){
       val document =database.collection(user.grade)
           .document(user.department)
           .collection(user.section)
           .document(user.userId)
        document
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val userStudent = it.result.toObject(UserStudent::class.java)
                    if (userStudent != null) {
                        setSession(userStudent)
                    }
                    result.invoke(userStudent)
                }else{
                    result.invoke(null)
                }
            }
            .addOnFailureListener {
                result.invoke(null)
            }
    }

    override fun getSessionStudent(result: (UserStudent?) -> Unit) {
        val user = appPreferences.getString(SharedPreferencesTable.user_session,null)
        if (user==null){
            result.invoke(null)
        }else{
            val userStudent = gson.fromJson(user, UserStudent::class.java)
            result.invoke(userStudent)
        }
    }
    override  suspend fun getUserStudent(id :String,section:String,dep:String,grade:String, result:(Resource<UserStudent?>) -> Unit) {

        val docRef =  database.collection(grade)
            .document(dep)
            .collection(section)
            .document(id)
        docRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                result.invoke(Resource.Failure(e.toString()))
                return@addSnapshotListener
            }
            result.invoke(Resource.Success(snapshot?.toObject(UserStudent::class.java)))
        }
    }
    override fun setSession(user:UserStudent) {
        appPreferences.edit().putString(SharedPreferencesTable.user_session,gson.toJson(user)).apply()
    }


    override suspend fun addPermission(permission: Permission, result: (Resource<String>) -> Unit) {
        val document=database.collection(PermissionsRequired.sing_in_permission).document(permission.userId)
        permission.permissionId=document.id
        document.set(permission)
            .addOnSuccessListener {
                result.invoke(
                    Resource.Success("asking for permission")
                )
            }
            .addOnFailureListener{
                result.invoke(
                    Resource.Failure(
                        it.localizedMessage
                    )
                )
            }

    }


}