package com.uni.unistudent.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020.H\u0002J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001a\u00108\u001a\u00020.2\u0006\u00109\u001a\u0002012\b\u00106\u001a\u0004\u0018\u000107H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010\u000e\u001a\u0004\b*\u0010+\u00a8\u0006:"}, d2 = {"Lcom/uni/unistudent/ui/fragments/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/uni/unistudent/adapters/PostsAdapter;", "getAdapter", "()Lcom/uni/unistudent/adapters/PostsAdapter;", "setAdapter", "(Lcom/uni/unistudent/adapters/PostsAdapter;)V", "authViewModel", "Lcom/uni/unistudent/viewModel/AuthViewModel;", "getAuthViewModel", "()Lcom/uni/unistudent/viewModel/AuthViewModel;", "authViewModel$delegate", "Lkotlin/Lazy;", "coursesList", "", "Lcom/uni/unistudent/classes/Courses;", "getCoursesList", "()Ljava/util/List;", "setCoursesList", "(Ljava/util/List;)V", "currentUser", "Lcom/uni/unistudent/classes/user/UserStudent;", "postsList", "Lcom/uni/unistudent/classes/Posts;", "getPostsList", "setPostsList", "progress", "Landroid/widget/ProgressBar;", "getProgress", "()Landroid/widget/ProgressBar;", "setProgress", "(Landroid/widget/ProgressBar;)V", "swipeRefreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "getSwipeRefreshLayout", "()Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "setSwipeRefreshLayout", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;)V", "viewModel", "Lcom/uni/unistudent/viewModel/FirebaseViewModel;", "getViewModel", "()Lcom/uni/unistudent/viewModel/FirebaseViewModel;", "viewModel$delegate", "observe", "", "observeCourses", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class HomeFragment extends androidx.fragment.app.Fragment {
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy authViewModel$delegate = null;
    public android.widget.ProgressBar progress;
    private com.uni.unistudent.classes.user.UserStudent currentUser;
    public androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefreshLayout;
    public java.util.List<com.uni.unistudent.classes.Courses> coursesList;
    public com.uni.unistudent.adapters.PostsAdapter adapter;
    public java.util.List<com.uni.unistudent.classes.Posts> postsList;
    
    public HomeFragment() {
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
    public final androidx.swiperefreshlayout.widget.SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }
    
    public final void setSwipeRefreshLayout(@org.jetbrains.annotations.NotNull
    androidx.swiperefreshlayout.widget.SwipeRefreshLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.uni.unistudent.classes.Courses> getCoursesList() {
        return null;
    }
    
    public final void setCoursesList(@org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.Courses> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uni.unistudent.adapters.PostsAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.adapters.PostsAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.uni.unistudent.classes.Posts> getPostsList() {
        return null;
    }
    
    public final void setPostsList(@org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.Posts> p0) {
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
    
    private final void observeCourses() {
    }
    
    private final void observe() {
    }
}