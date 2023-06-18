package com.uni.unistudent.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ3\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u00100\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00102\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u00100\u0014H\u0016JM\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00162\u001a\u0010\u0013\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\u00100\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u001f\u0010 \u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100!H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"JC\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00192\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u00100\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0019H\u0016J.\u0010)\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u00192\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u00100\u0014H\u0016J3\u0010*\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00192\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u00100\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2 = {"Lcom/uni/unistudent/data/AuthRepositoryImpl;", "Lcom/uni/unistudent/data/AuthRepository;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "database", "Lcom/google/firebase/firestore/FirebaseFirestore;", "appPreferences", "Landroid/content/SharedPreferences;", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/firebase/auth/FirebaseAuth;Lcom/google/firebase/firestore/FirebaseFirestore;Landroid/content/SharedPreferences;Lcom/google/gson/Gson;)V", "user", "Lcom/google/firebase/auth/FirebaseUser;", "getUser", "()Lcom/google/firebase/auth/FirebaseUser;", "addPermission", "", "permission", "Lcom/uni/unistudent/classes/Permission;", "result", "Lkotlin/Function1;", "Lcom/uni/unistudent/data/Resource;", "", "(Lcom/uni/unistudent/classes/Permission;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSessionStudent", "Lcom/uni/unistudent/classes/user/UserStudent;", "getUserStudent", "id", "section", "dep", "grade", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logOut", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "email", "password", "userTeaching", "(Ljava/lang/String;Ljava/lang/String;Lcom/uni/unistudent/classes/user/UserStudent;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSession", "storeSession", "updateUserInfo", "(Lcom/uni/unistudent/classes/user/UserStudent;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AuthRepositoryImpl implements com.uni.unistudent.data.AuthRepository {
    private final com.google.firebase.auth.FirebaseAuth firebaseAuth = null;
    private final com.google.firebase.firestore.FirebaseFirestore database = null;
    private final android.content.SharedPreferences appPreferences = null;
    private final com.google.gson.Gson gson = null;
    
    @javax.inject.Inject
    public AuthRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.google.firebase.auth.FirebaseAuth firebaseAuth, @org.jetbrains.annotations.NotNull
    com.google.firebase.firestore.FirebaseFirestore database, @org.jetbrains.annotations.NotNull
    android.content.SharedPreferences appPreferences, @org.jetbrains.annotations.NotNull
    com.google.gson.Gson gson) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object updateUserInfo(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.user.UserStudent userTeaching, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.data.Resource<java.lang.String>, kotlin.Unit> result, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public com.google.firebase.auth.FirebaseUser getUser() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object register(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.user.UserStudent userTeaching, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.data.Resource<java.lang.String>, kotlin.Unit> result, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object logOut(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> result, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @java.lang.Override
    public void storeSession(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.user.UserStudent user, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.classes.user.UserStudent, kotlin.Unit> result) {
    }
    
    @java.lang.Override
    public void getSessionStudent(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.classes.user.UserStudent, kotlin.Unit> result) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getUserStudent(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String section, @org.jetbrains.annotations.NotNull
    java.lang.String dep, @org.jetbrains.annotations.NotNull
    java.lang.String grade, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.data.Resource<com.uni.unistudent.classes.user.UserStudent>, kotlin.Unit> result, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @java.lang.Override
    public void setSession(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.user.UserStudent user) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object addPermission(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.Permission permission, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.data.Resource<java.lang.String>, kotlin.Unit> result, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}