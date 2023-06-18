package com.uni.unistudent.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0012\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001bH\u0014J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020\u001bH\u0002J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\'"}, d2 = {"Lcom/uni/unistudent/ui/HomeScreen;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/uni/unistudent/databinding/ActivityHomeScreenBinding;", "currentUser", "Lcom/uni/unistudent/classes/user/UserStudent;", "getCurrentUser", "()Lcom/uni/unistudent/classes/user/UserStudent;", "setCurrentUser", "(Lcom/uni/unistudent/classes/user/UserStudent;)V", "storageViewModel", "Lcom/uni/unistudent/viewModel/FireStorageViewModel;", "getStorageViewModel", "()Lcom/uni/unistudent/viewModel/FireStorageViewModel;", "storageViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/uni/unistudent/viewModel/AuthViewModel;", "getViewModel", "()Lcom/uni/unistudent/viewModel/AuthViewModel;", "viewModel$delegate", "checkForInternet", "", "context", "Landroid/content/Context;", "observeImage", "", "observeUser", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "replaceFragment", "fragment", "Landroidx/fragment/app/Fragment;", "settingsOnStartApp", "updateUser", "user", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class HomeScreen extends androidx.appcompat.app.AppCompatActivity {
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy storageViewModel$delegate = null;
    public com.uni.unistudent.classes.user.UserStudent currentUser;
    private com.uni.unistudent.databinding.ActivityHomeScreenBinding binding;
    
    public HomeScreen() {
        super();
    }
    
    private final com.uni.unistudent.viewModel.AuthViewModel getViewModel() {
        return null;
    }
    
    private final com.uni.unistudent.viewModel.FireStorageViewModel getStorageViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uni.unistudent.classes.user.UserStudent getCurrentUser() {
        return null;
    }
    
    public final void setCurrentUser(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.user.UserStudent p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    public final void replaceFragment(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment fragment) {
    }
    
    private final void updateUser(com.uni.unistudent.classes.user.UserStudent user) {
    }
    
    private final void observeImage() {
    }
    
    private final void observeUser() {
    }
    
    @java.lang.Override
    protected void onStart() {
    }
    
    private final boolean checkForInternet(android.content.Context context) {
        return false;
    }
    
    private final void settingsOnStartApp() {
    }
}