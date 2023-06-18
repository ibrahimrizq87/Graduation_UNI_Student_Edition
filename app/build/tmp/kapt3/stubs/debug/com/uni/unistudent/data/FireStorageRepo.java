package com.uni.unistudent.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ3\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ;\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/uni/unistudent/data/FireStorageRepo;", "", "downloadPostUri", "", "postId", "", "result", "Lkotlin/Function1;", "Lcom/uni/unistudent/data/Resource;", "Landroid/net/Uri;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadUri", "userId", "uploadImage", "imageUri", "(Landroid/net/Uri;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface FireStorageRepo {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object downloadUri(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.data.Resource<? extends android.net.Uri>, kotlin.Unit> result, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object uploadImage(@org.jetbrains.annotations.NotNull
    android.net.Uri imageUri, @org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.data.Resource<java.lang.String>, kotlin.Unit> result, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object downloadPostUri(@org.jetbrains.annotations.NotNull
    java.lang.String postId, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.data.Resource<? extends android.net.Uri>, kotlin.Unit> result, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}