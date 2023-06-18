package com.uni.unistudent.data.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/uni/unistudent/data/di/FirebaseModule;", "", "()V", "provideFireAuthInstant", "Lcom/google/firebase/auth/FirebaseAuth;", "provideFireRealtimeInstant", "Lcom/google/firebase/database/DatabaseReference;", "provideFireStorageInstant", "Lcom/google/firebase/storage/StorageReference;", "provideFireStoreInstant", "Lcom/google/firebase/firestore/FirebaseFirestore;", "app_debug"})
@dagger.Module
public final class FirebaseModule {
    @org.jetbrains.annotations.NotNull
    public static final com.uni.unistudent.data.di.FirebaseModule INSTANCE = null;
    
    private FirebaseModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.google.firebase.firestore.FirebaseFirestore provideFireStoreInstant() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.google.firebase.storage.StorageReference provideFireStorageInstant() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.google.firebase.auth.FirebaseAuth provideFireAuthInstant() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.google.firebase.database.DatabaseReference provideFireRealtimeInstant() {
        return null;
    }
}