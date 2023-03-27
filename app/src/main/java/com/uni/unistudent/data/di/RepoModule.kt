package com.uni.unistudent.data.di


import android.content.SharedPreferences
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.gson.Gson
import com.uni.unistudent.data.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object
RepoModule {

    @Provides
    @Singleton
    fun provideFirebaseRepo(
         database:FirebaseFirestore,
    ): FirebaseRepo {
        return FirebaseRepoImp(database)
    }

    @Provides
    @Singleton
    fun provideFireStorageRepo(
        database:StorageReference,
    ): FireStorageRepo {
        return FireStorageRepoImp(database)
    }


    @Provides
    @Singleton
    fun provideAuthRepo(
        database:FirebaseFirestore,
        auth:FirebaseAuth,
        appPreferences: SharedPreferences,
        gson: Gson
    ): AuthRepository {
        return AuthRepositoryImpl(auth,database,appPreferences,gson)
    }


    @Provides
    @Singleton
    fun provideRealtimeRepo(
        database: DatabaseReference,
    ):FirebaseRealtimeRepo {
        return FirebaseRealtimeRepoImp(database)
    }
}