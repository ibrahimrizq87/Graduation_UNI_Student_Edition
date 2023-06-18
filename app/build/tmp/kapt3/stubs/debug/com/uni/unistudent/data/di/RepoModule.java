package com.uni.unistudent.data.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0014H\u0007\u00a8\u0006\u0015"}, d2 = {"Lcom/uni/unistudent/data/di/RepoModule;", "", "()V", "provideAuthRepo", "Lcom/uni/unistudent/data/AuthRepository;", "database", "Lcom/google/firebase/firestore/FirebaseFirestore;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "appPreferences", "Landroid/content/SharedPreferences;", "gson", "Lcom/google/gson/Gson;", "provideFireStorageRepo", "Lcom/uni/unistudent/data/FireStorageRepo;", "Lcom/google/firebase/storage/StorageReference;", "provideFirebaseRepo", "Lcom/uni/unistudent/data/FirebaseRepo;", "provideRealtimeRepo", "Lcom/uni/unistudent/data/FirebaseRealtimeRepo;", "Lcom/google/firebase/database/DatabaseReference;", "app_debug"})
@dagger.Module
public final class RepoModule {
    @org.jetbrains.annotations.NotNull
    public static final com.uni.unistudent.data.di.RepoModule INSTANCE = null;
    
    private RepoModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.uni.unistudent.data.FirebaseRepo provideFirebaseRepo(@org.jetbrains.annotations.NotNull
    com.google.firebase.firestore.FirebaseFirestore database) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.uni.unistudent.data.FireStorageRepo provideFireStorageRepo(@org.jetbrains.annotations.NotNull
    com.google.firebase.storage.StorageReference database) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.uni.unistudent.data.AuthRepository provideAuthRepo(@org.jetbrains.annotations.NotNull
    com.google.firebase.firestore.FirebaseFirestore database, @org.jetbrains.annotations.NotNull
    com.google.firebase.auth.FirebaseAuth auth, @org.jetbrains.annotations.NotNull
    android.content.SharedPreferences appPreferences, @org.jetbrains.annotations.NotNull
    com.google.gson.Gson gson) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.uni.unistudent.data.FirebaseRealtimeRepo provideRealtimeRepo(@org.jetbrains.annotations.NotNull
    com.google.firebase.database.DatabaseReference database) {
        return null;
    }
}