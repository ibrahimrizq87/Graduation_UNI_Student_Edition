package com.uni.unistudent.data

import android.net.Uri

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


    //here there is a big problem but easy to be fixed first the image is being downloaded
    // every time the app is running so we want to save it in the local storage and second is
    // that it is downloaded by the the url not the uri
    //https://firebase.google.com/docs/storage/android/download-files

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
    override suspend fun downloadPostUri(postId: String, result: (Resource<Uri>) -> Unit) {
        val downloadUriTask=mStorageRef.child("posts/$postId.png").downloadUrl
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