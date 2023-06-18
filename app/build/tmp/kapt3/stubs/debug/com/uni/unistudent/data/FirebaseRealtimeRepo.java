package com.uni.unistudent.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00030\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/uni/unistudent/data/FirebaseRealtimeRepo;", "", "getAttendWithCode", "", "embeddedId", "", "scannedCode", "", "result", "Lkotlin/Function1;", "Lcom/uni/unistudent/data/Resource;", "", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface FirebaseRealtimeRepo {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAttendWithCode(@org.jetbrains.annotations.NotNull
    java.lang.String embeddedId, int scannedCode, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.uni.unistudent.data.Resource<java.lang.Boolean>, kotlin.Unit> result, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}