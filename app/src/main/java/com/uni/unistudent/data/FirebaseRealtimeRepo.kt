package com.uni.unistudent.data


interface FirebaseRealtimeRepo {
    suspend fun getAttendWithCode(embeddedId:String,scannedCode:Int,result :(Resource<Boolean>) ->Unit)
}