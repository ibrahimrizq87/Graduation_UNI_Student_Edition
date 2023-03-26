package com.uni.unistudent.data.di


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object FirebaseModule {

@Provides
@Singleton
fun provideFireStoreInstant():FirebaseFirestore{
    return FirebaseFirestore.getInstance()
}

    @Provides
    @Singleton
    fun provideFireStorageInstant(): StorageReference {
        return FirebaseStorage.getInstance().reference
    }



    @Provides
    @Singleton
    fun provideFireAuthInstant(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
    @Provides
    @Singleton
    fun provideFireRealtimeInstant(): DatabaseReference {
        return Firebase.database.reference
    }
}