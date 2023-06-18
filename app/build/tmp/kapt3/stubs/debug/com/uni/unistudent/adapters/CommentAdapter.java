package com.uni.unistudent.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\'BO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\u0002\u0010\rJ\b\u0010\u001d\u001a\u00020\nH\u0016J\u001c\u0010\u001e\u001a\u00020\u000b2\n\u0010\u001f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020\nH\u0016J\u001c\u0010!\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\nH\u0016J\u0014\u0010%\u001a\u00020\u000b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R#\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001b\u00a8\u0006("}, d2 = {"Lcom/uni/unistudent/adapters/CommentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/uni/unistudent/adapters/CommentAdapter$myViewHolder;", "context", "Landroid/content/Context;", "commentList", "", "Lcom/uni/unistudent/classes/MyComments;", "onUpdate", "Lkotlin/Function2;", "", "", "onDelete", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getCommentList", "()Ljava/util/List;", "setCommentList", "(Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "instance", "Landroid/view/View;", "getInstance", "()Landroid/view/View;", "setInstance", "(Landroid/view/View;)V", "getOnDelete", "()Lkotlin/jvm/functions/Function2;", "getOnUpdate", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "list", "myViewHolder", "app_debug"})
public final class CommentAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.uni.unistudent.adapters.CommentAdapter.myViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.uni.unistudent.classes.MyComments> commentList;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function2<java.lang.Integer, com.uni.unistudent.classes.MyComments, kotlin.Unit> onUpdate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function2<java.lang.Integer, com.uni.unistudent.classes.MyComments, kotlin.Unit> onDelete = null;
    public android.view.View instance;
    
    public CommentAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.MyComments> commentList, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super com.uni.unistudent.classes.MyComments, kotlin.Unit> onUpdate, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super com.uni.unistudent.classes.MyComments, kotlin.Unit> onDelete) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.uni.unistudent.classes.MyComments> getCommentList() {
        return null;
    }
    
    public final void setCommentList(@org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.MyComments> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function2<java.lang.Integer, com.uni.unistudent.classes.MyComments, kotlin.Unit> getOnUpdate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function2<java.lang.Integer, com.uni.unistudent.classes.MyComments, kotlin.Unit> getOnDelete() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.view.View getInstance() {
        return null;
    }
    
    public final void setInstance(@org.jetbrains.annotations.NotNull
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.uni.unistudent.adapters.CommentAdapter.myViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.adapters.CommentAdapter.myViewHolder holder, int position) {
    }
    
    public final void update(@org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.MyComments> list) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0011\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/uni/unistudent/adapters/CommentAdapter$myViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Lcom/uni/unistudent/adapters/CommentAdapter;Landroid/view/View;)V", "auth", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getAuth", "()Landroid/widget/TextView;", "auth_id", "getAuth_id", "comment", "getComment", "delete_bt", "Landroid/widget/ImageButton;", "getDelete_bt", "()Landroid/widget/ImageButton;", "time", "getTime", "update_bt", "getUpdate_bt", "app_debug"})
    public final class myViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView auth = null;
        private final android.widget.TextView auth_id = null;
        private final android.widget.TextView comment = null;
        private final android.widget.TextView time = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageButton update_bt = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageButton delete_bt = null;
        
        public myViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View item) {
            super(null);
        }
        
        public final android.widget.TextView getAuth() {
            return null;
        }
        
        public final android.widget.TextView getAuth_id() {
            return null;
        }
        
        public final android.widget.TextView getComment() {
            return null;
        }
        
        public final android.widget.TextView getTime() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageButton getUpdate_bt() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageButton getDelete_bt() {
            return null;
        }
    }
}