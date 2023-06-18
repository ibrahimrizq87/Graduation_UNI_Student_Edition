package com.uni.unistudent.viewModel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/uni/unistudent/viewModel/FirebaseRealtimeModelView;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/uni/unistudent/data/FirebaseRealtimeRepo;", "(Lcom/uni/unistudent/data/FirebaseRealtimeRepo;)V", "_getAttendanceCode", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/uni/unistudent/data/Resource;", "", "getAttendanceCode", "Lkotlinx/coroutines/flow/StateFlow;", "getGetAttendanceCode", "()Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/Job;", "embeddedId", "", "scannedCode", "", "app_debug"})
public final class FirebaseRealtimeModelView extends androidx.lifecycle.ViewModel {
    private final com.uni.unistudent.data.FirebaseRealtimeRepo repository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.uni.unistudent.data.Resource<java.lang.Boolean>> _getAttendanceCode = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.lang.Boolean>> getAttendanceCode = null;
    
    @javax.inject.Inject
    public FirebaseRealtimeModelView(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.data.FirebaseRealtimeRepo repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.lang.Boolean>> getGetAttendanceCode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getAttendanceCode(@org.jetbrains.annotations.NotNull
    java.lang.String embeddedId, int scannedCode) {
        return null;
    }
}