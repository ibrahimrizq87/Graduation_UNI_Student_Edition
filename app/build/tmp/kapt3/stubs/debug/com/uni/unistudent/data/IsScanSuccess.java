package com.uni.unistudent.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/uni/unistudent/data/IsScanSuccess;", "", "isScanSuccess", "", "flag", "", "qr", "", "Companion", "app_debug"})
public abstract interface IsScanSuccess {
    @org.jetbrains.annotations.NotNull
    public static final com.uni.unistudent.data.IsScanSuccess.Companion Companion = null;
    
    public abstract void isScanSuccess(boolean flag, @org.jetbrains.annotations.NotNull
    java.lang.String qr);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/uni/unistudent/data/IsScanSuccess$Companion;", "", "()V", "listener", "Lcom/uni/unistudent/data/IsScanSuccess;", "set", "", "flag", "", "qr", "", "setListener", "app_debug"})
    public static final class Companion {
        private static com.uni.unistudent.data.IsScanSuccess listener;
        
        private Companion() {
            super();
        }
        
        public final void setListener(@org.jetbrains.annotations.NotNull
        com.uni.unistudent.data.IsScanSuccess listener) {
        }
        
        public final void set(boolean flag, @org.jetbrains.annotations.NotNull
        java.lang.String qr) {
        }
    }
}