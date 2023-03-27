package com.uni.unistudent.data

import com.google.firebase.database.DatabaseReference
import com.uni.unistudent.classes.EmbeddedModel
import javax.inject.Inject

class FirebaseRealtimeRepoImp @Inject constructor(
    private val database: DatabaseReference
        ):FirebaseRealtimeRepo{
    override  suspend fun getAttendWithCode(embeddedId:String,scannedCode:Int,result :(Resource<Boolean>) ->Unit){
        database.child("embedded").child(embeddedId)
            .get()
            .addOnSuccessListener {
                val data = it.getValue(EmbeddedModel::class.java)
                if (data!!.code==scannedCode){
                    result.invoke(Resource.Success(true))
                }else{
                    result.invoke(Resource.Success(false))
                }
            }
            .addOnFailureListener {
                result.invoke(Resource.Failure(it.localizedMessage))
            }
    }


}