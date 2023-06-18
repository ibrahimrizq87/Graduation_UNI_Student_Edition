package com.uni.unistudent.viewModel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\nJ\u001c\u0010\u001a\u001a\u00020\u001b2\u0014\u0010\u001c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u001b0\u001dJ&\u0010\u0014\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bJ\u0014\u0010\"\u001a\u00020\u00162\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0#J\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\nR\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\u0013\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012\u00a8\u0006%"}, d2 = {"Lcom/uni/unistudent/viewModel/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/uni/unistudent/data/AuthRepository;", "(Lcom/uni/unistudent/data/AuthRepository;)V", "_register", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/uni/unistudent/data/Resource;", "", "_userStudent", "Lcom/uni/unistudent/classes/user/UserStudent;", "currentUser", "Lcom/google/firebase/auth/FirebaseUser;", "getCurrentUser", "()Lcom/google/firebase/auth/FirebaseUser;", "register", "Lkotlinx/coroutines/flow/StateFlow;", "getRegister", "()Lkotlinx/coroutines/flow/StateFlow;", "userStudent", "getUserStudent", "Register", "Lkotlinx/coroutines/Job;", "email", "password", "user", "getSessionStudent", "", "result", "Lkotlin/Function1;", "id", "section", "dep", "grade", "logOut", "Lkotlin/Function0;", "setSession", "app_debug"})
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    private final com.uni.unistudent.data.AuthRepository repository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.uni.unistudent.data.Resource<java.lang.String>> _register = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.lang.String>> register = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.uni.unistudent.data.Resource<com.uni.unistudent.classes.user.UserStudent>> _userStudent = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<com.uni.unistudent.classes.user.UserStudent>> userStudent = null;
    
    @javax.inject.Inject
    public AuthViewModel(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.data.AuthRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.lang.String>> getRegister() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<com.uni.unistudent.classes.user.UserStudent>> getUserStudent() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.google.firebase.auth.FirebaseUser getCurrentUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job Register(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.user.UserStudent user) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getUserStudent(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String section, @org.jetbrains.annotations.NotNull
    java.lang.String dep, @org.jetbrains.annotations.NotNull
    java.lang.String grade) {
        return null;
    }
    
    public final void setSession(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.user.UserStudent user) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job logOut(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> result) {
        return null;
    }
    
    public final void getSessionStudent(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.classes.user.UserStudent, kotlin.Unit> result) {
    }
}