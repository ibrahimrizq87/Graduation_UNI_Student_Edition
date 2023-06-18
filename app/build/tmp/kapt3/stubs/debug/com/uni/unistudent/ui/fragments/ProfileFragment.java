package com.uni.unistudent.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J&\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000103H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\tR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\'\u0010\u000f\u001a\u0004\b%\u0010&\u00a8\u00064"}, d2 = {"Lcom/uni/unistudent/ui/fragments/ProfileFragment;", "Landroidx/fragment/app/Fragment;", "()V", "assistantList", "", "Lcom/uni/unistudent/classes/Assistant;", "getAssistantList", "()Ljava/util/List;", "setAssistantList", "(Ljava/util/List;)V", "authViewModel", "Lcom/uni/unistudent/viewModel/AuthViewModel;", "getAuthViewModel", "()Lcom/uni/unistudent/viewModel/AuthViewModel;", "authViewModel$delegate", "Lkotlin/Lazy;", "coursesList", "Lcom/uni/unistudent/classes/Courses;", "getCoursesList", "setCoursesList", "currentUser", "Lcom/uni/unistudent/classes/user/UserStudent;", "getCurrentUser", "()Lcom/uni/unistudent/classes/user/UserStudent;", "setCurrentUser", "(Lcom/uni/unistudent/classes/user/UserStudent;)V", "lecturerList", "Lcom/uni/unistudent/classes/Professor;", "getLecturerList", "setLecturerList", "storageViewModel", "Lcom/uni/unistudent/viewModel/FireStorageViewModel;", "getStorageViewModel", "()Lcom/uni/unistudent/viewModel/FireStorageViewModel;", "storageViewModel$delegate", "viewModel", "Lcom/uni/unistudent/viewModel/FirebaseViewModel;", "getViewModel", "()Lcom/uni/unistudent/viewModel/FirebaseViewModel;", "viewModel$delegate", "observeAssistant", "", "observeCourses", "observeLecturers", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class ProfileFragment extends androidx.fragment.app.Fragment {
    public java.util.List<com.uni.unistudent.classes.Courses> coursesList;
    public java.util.List<com.uni.unistudent.classes.Professor> lecturerList;
    public java.util.List<com.uni.unistudent.classes.Assistant> assistantList;
    public com.uni.unistudent.classes.user.UserStudent currentUser;
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy authViewModel$delegate = null;
    private final kotlin.Lazy storageViewModel$delegate = null;
    
    public ProfileFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.uni.unistudent.classes.Courses> getCoursesList() {
        return null;
    }
    
    public final void setCoursesList(@org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.Courses> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.uni.unistudent.classes.Professor> getLecturerList() {
        return null;
    }
    
    public final void setLecturerList(@org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.Professor> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.uni.unistudent.classes.Assistant> getAssistantList() {
        return null;
    }
    
    public final void setAssistantList(@org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.Assistant> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uni.unistudent.classes.user.UserStudent getCurrentUser() {
        return null;
    }
    
    public final void setCurrentUser(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.user.UserStudent p0) {
    }
    
    private final com.uni.unistudent.viewModel.FirebaseViewModel getViewModel() {
        return null;
    }
    
    private final com.uni.unistudent.viewModel.AuthViewModel getAuthViewModel() {
        return null;
    }
    
    private final com.uni.unistudent.viewModel.FireStorageViewModel getStorageViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void observeCourses() {
    }
    
    private final void observeAssistant() {
    }
    
    private final void observeLecturers() {
    }
}