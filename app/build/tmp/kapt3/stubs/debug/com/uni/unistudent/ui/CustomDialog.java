package com.uni.unistudent.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/uni/unistudent/ui/CustomDialog;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "builder", "Landroid/app/AlertDialog$Builder;", "inflater", "Landroid/view/LayoutInflater;", "isShowFailed", "", "isShowNotOurCode", "isShowWait", "waitDialog", "Landroid/app/AlertDialog;", "hideWaitDialog", "", "showFailed", "showNotOurCode", "showSuccess", "showWait", "app_debug"})
public final class CustomDialog {
    private final androidx.fragment.app.FragmentActivity activity = null;
    private android.app.AlertDialog waitDialog;
    private final android.app.AlertDialog.Builder builder = null;
    private final android.view.LayoutInflater inflater = null;
    private boolean isShowFailed = false;
    private boolean isShowWait = false;
    private boolean isShowNotOurCode = false;
    
    public CustomDialog(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity activity) {
        super();
    }
    
    public final void showWait() {
    }
    
    private final void hideWaitDialog() {
    }
    
    public final void showSuccess() {
    }
    
    public final void showFailed() {
    }
    
    public final void showNotOurCode() {
    }
}