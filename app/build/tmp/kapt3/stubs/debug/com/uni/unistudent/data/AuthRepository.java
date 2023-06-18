package com.uni.unistudent.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J3\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u00070\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\u00072\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00070\u000bH&JM\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u001a\u0010\n\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f\u0012\u0004\u0012\u00020\u00070\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019JC\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00102\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u00070\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0010H&J.\u0010 \u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00102\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00070\u000bH&J3\u0010!\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00102\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u00070\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/uni/unistudent/data/AuthRepository;", "", "user", "Lcom/google/firebase/auth/FirebaseUser;", "getUser", "()Lcom/google/firebase/auth/FirebaseUser;", "addPermission", "", "permission", "Lcom/uni/unistudent/classes/Permission;", "result", "Lkotlin/Function1;", "Lcom/uni/unistudent/data/Resource;", "", "(Lcom/uni/unistudent/classes/Permission;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSessionStudent", "Lcom/uni/unistudent/classes/user/UserStudent;", "getUserStudent", "id", "section", "dep", "grade", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logOut", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "email", "password", "userTeaching", "(Ljava/lang/String;Ljava/lang/String;Lcom/uni/unistudent/classes/user/UserStudent;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSession", "storeSession", "updateUserInfo", "(Lcom/uni/unistudent/classes/user/UserStudent;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface AuthRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract com.google.firebase.auth.FirebaseUser getUser();
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateUserInfo(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.user.UserStudent userTeaching, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.data.Resource<java.lang.String>, kotlin.Unit> result, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object register(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.user.UserStudent userTeaching, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.data.Resource<java.lang.String>, kotlin.Unit> result, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object logOut(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> result, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addPermission(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.Permission permission, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.data.Resource<java.lang.String>, kotlin.Unit> result, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    public abstract void storeSession(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.user.UserStudent user, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.classes.user.UserStudent, kotlin.Unit> result);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserStudent(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String section, @org.jetbrains.annotations.NotNull
    java.lang.String dep, @org.jetbrains.annotations.NotNull
    java.lang.String grade, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.data.Resource<com.uni.unistudent.classes.user.UserStudent>, kotlin.Unit> result, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    public abstract void getSessionStudent(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.classes.user.UserStudent, kotlin.Unit> result);
    
    public abstract void setSession(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.user.UserStudent user);
}