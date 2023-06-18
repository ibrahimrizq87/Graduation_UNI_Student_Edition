package com.uni.unistudent.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000206H\u0002J\b\u00108\u001a\u000206H\u0002J&\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0010\u0010A\u001a\u0002062\u0006\u0010B\u001a\u00020!H\u0016J\u001a\u0010C\u001a\u0002062\u0006\u0010D\u001a\u00020:2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R \u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0016\"\u0004\b/\u0010\u0018R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010\u000f\u001a\u0004\b2\u00103\u00a8\u0006E"}, d2 = {"Lcom/uni/unistudent/ui/fragments/ScheduleFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/uni/unistudent/adapters/DaysAdapter$CustomClickListener;", "()V", "adapter", "Lcom/uni/unistudent/adapters/ScheduleAdapter;", "getAdapter", "()Lcom/uni/unistudent/adapters/ScheduleAdapter;", "setAdapter", "(Lcom/uni/unistudent/adapters/ScheduleAdapter;)V", "authViewModel", "Lcom/uni/unistudent/viewModel/AuthViewModel;", "getAuthViewModel", "()Lcom/uni/unistudent/viewModel/AuthViewModel;", "authViewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/uni/unistudent/databinding/FragmentScheduleBinding;", "coursesList", "", "Lcom/uni/unistudent/classes/Courses;", "getCoursesList", "()Ljava/util/List;", "setCoursesList", "(Ljava/util/List;)V", "currentUser", "Lcom/uni/unistudent/classes/user/UserStudent;", "getCurrentUser", "()Lcom/uni/unistudent/classes/user/UserStudent;", "setCurrentUser", "(Lcom/uni/unistudent/classes/user/UserStudent;)V", "daySelected", "Landroidx/lifecycle/MutableLiveData;", "", "isCorLoaded", "", "isLecLoaded", "isSecLoaded", "progress", "Landroid/widget/ProgressBar;", "getProgress", "()Landroid/widget/ProgressBar;", "setProgress", "(Landroid/widget/ProgressBar;)V", "scheduleDataType", "Lcom/uni/unistudent/classes/ScheduleDataType;", "getScheduleDataType", "setScheduleDataType", "viewModel", "Lcom/uni/unistudent/viewModel/FirebaseViewModel;", "getViewModel", "()Lcom/uni/unistudent/viewModel/FirebaseViewModel;", "viewModel$delegate", "observeCourses", "", "observeLectures", "observeSections", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCustomClick", "day", "onViewCreated", "view", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class ScheduleFragment extends androidx.fragment.app.Fragment implements com.uni.unistudent.adapters.DaysAdapter.CustomClickListener {
    private com.uni.unistudent.databinding.FragmentScheduleBinding binding;
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy authViewModel$delegate = null;
    public android.widget.ProgressBar progress;
    public com.uni.unistudent.classes.user.UserStudent currentUser;
    private androidx.lifecycle.MutableLiveData<java.lang.String> daySelected;
    public java.util.List<com.uni.unistudent.classes.Courses> coursesList;
    public com.uni.unistudent.adapters.ScheduleAdapter adapter;
    public java.util.List<com.uni.unistudent.classes.ScheduleDataType> scheduleDataType;
    private boolean isLecLoaded = false;
    private boolean isSecLoaded = false;
    private boolean isCorLoaded = false;
    
    public ScheduleFragment() {
        super();
    }
    
    private final com.uni.unistudent.viewModel.FirebaseViewModel getViewModel() {
        return null;
    }
    
    private final com.uni.unistudent.viewModel.AuthViewModel getAuthViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.ProgressBar getProgress() {
        return null;
    }
    
    public final void setProgress(@org.jetbrains.annotations.NotNull
    android.widget.ProgressBar p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uni.unistudent.classes.user.UserStudent getCurrentUser() {
        return null;
    }
    
    public final void setCurrentUser(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.user.UserStudent p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.uni.unistudent.classes.Courses> getCoursesList() {
        return null;
    }
    
    public final void setCoursesList(@org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.Courses> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uni.unistudent.adapters.ScheduleAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.adapters.ScheduleAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.uni.unistudent.classes.ScheduleDataType> getScheduleDataType() {
        return null;
    }
    
    public final void setScheduleDataType(@org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.ScheduleDataType> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void observeSections() {
    }
    
    private final void observeLectures() {
    }
    
    private final void observeCourses() {
    }
    
    @java.lang.Override
    public void onCustomClick(@org.jetbrains.annotations.NotNull
    java.lang.String day) {
    }
}