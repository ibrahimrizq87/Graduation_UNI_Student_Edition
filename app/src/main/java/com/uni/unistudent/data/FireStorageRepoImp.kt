package com.uni.unistudent.data

import android.content.Context
import android.net.Uri
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference
import javax.inject.Inject

class FireStorageRepoImp@Inject constructor(
    private val mStorageRef: StorageReference
):FireStorageRepo {
    override suspend fun uploadImage( imageUri: Uri, userId:String, result: (Resource<String>) -> Unit){


        val uploadTask = mStorageRef.child("users/$userId.png").putFile(imageUri)
        uploadTask.addOnSuccessListener {
            result.invoke(
                Resource.Success("image uploaded")
            )
        }.addOnFailureListener{
            result.invoke(
                Resource.Failure(it.toString())
            )
        }
    }
    override suspend  fun downloadUri(userId:String ,result: (Resource<Uri>) -> Unit)  {


        val downloadUriTask=mStorageRef.child("users/$userId.png").downloadUrl
        downloadUriTask.addOnSuccessListener {
            result.invoke(
                Resource.Success(it)
            )
        }.addOnFailureListener {
            result.invoke(
                Resource.Failure(it.toString())
            )
        }
    }
}