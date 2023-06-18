package com.uni.unistudent.viewModel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bR\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/uni/unistudent/viewModel/FireStorageViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/uni/unistudent/data/FireStorageRepo;", "(Lcom/uni/unistudent/data/FireStorageRepo;)V", "_addUri", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/uni/unistudent/data/Resource;", "", "_getUri", "Landroid/net/Uri;", "addUri", "Lkotlinx/coroutines/flow/StateFlow;", "getAddUri", "()Lkotlinx/coroutines/flow/StateFlow;", "getUri", "getGetUri", "Lkotlinx/coroutines/Job;", "userId", "uri", "app_debug"})
public final class FireStorageViewModel extends androidx.lifecycle.ViewModel {
    private final com.uni.unistudent.data.FireStorageRepo repository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.uni.unistudent.data.Resource<android.net.Uri>> _getUri = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<android.net.Uri>> getUri = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.uni.unistudent.data.Resource<java.lang.String>> _addUri = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.lang.String>> addUri = null;
    
    @javax.inject.Inject
    public FireStorageViewModel(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.data.FireStorageRepo repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<android.net.Uri>> getGetUri() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.lang.String>> getAddUri() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getUri(@org.jetbrains.annotations.NotNull
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job addUri(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    android.net.Uri uri) {
        return null;
    }
}