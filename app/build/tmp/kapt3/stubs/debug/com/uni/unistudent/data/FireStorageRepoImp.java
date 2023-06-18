package com.uni.unistudent.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J3\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ3\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ;\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\b2\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/uni/unistudent/data/FireStorageRepoImp;", "Lcom/uni/unistudent/data/FireStorageRepo;", "mStorageRef", "Lcom/google/firebase/storage/StorageReference;", "(Lcom/google/firebase/storage/StorageReference;)V", "downloadPostUri", "", "postId", "", "result", "Lkotlin/Function1;", "Lcom/uni/unistudent/data/Resource;", "Landroid/net/Uri;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadUri", "userId", "uploadImage", "imageUri", "(Landroid/net/Uri;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class FireStorageRepoImp implements com.uni.unistudent.data.FireStorageRepo {
    private final com.google.firebase.storage.StorageReference mStorageRef = null;
    
    @javax.inject.Inject
    public FireStorageRepoImp(@org.jetbrains.annotations.NotNull
    com.google.firebase.storage.StorageReference mStorageRef) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object uploadImage(@org.jetbrains.annotations.NotNull
    android.net.Uri imageUri, @org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.data.Resource<java.lang.String>, kotlin.Unit> result, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object downloadUri(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.data.Resource<? extends android.net.Uri>, kotlin.Unit> result, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object downloadPostUri(@org.jetbrains.annotations.NotNull
    java.lang.String postId, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.data.Resource<? extends android.net.Uri>, kotlin.Unit> result, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}