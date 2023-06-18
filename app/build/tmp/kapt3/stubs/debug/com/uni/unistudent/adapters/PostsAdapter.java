package com.uni.unistudent.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\"#$BO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\u0002\u0010\rJ\b\u0010\u0017\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0014\u0010 \u001a\u00020\u000b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR#\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006%"}, d2 = {"Lcom/uni/unistudent/adapters/PostsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "postList", "", "Lcom/uni/unistudent/classes/Posts;", "onItemClicked", "Lkotlin/Function2;", "", "", "onComment", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getContext", "()Landroid/content/Context;", "getOnComment", "()Lkotlin/jvm/functions/Function2;", "getOnItemClicked", "getPostList", "()Ljava/util/List;", "setPostList", "(Ljava/util/List;)V", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "list", "Companion", "ViewHolder1", "ViewHolder2", "app_debug"})
public final class PostsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.uni.unistudent.classes.Posts> postList;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function2<java.lang.Integer, com.uni.unistudent.classes.Posts, kotlin.Unit> onItemClicked = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function2<java.lang.Integer, com.uni.unistudent.classes.Posts, kotlin.Unit> onComment = null;
    @org.jetbrains.annotations.NotNull
    public static final com.uni.unistudent.adapters.PostsAdapter.Companion Companion = null;
    public static final int WITH_IMAGE = 1;
    public static final int WITHOUT_IMAGE = 2;
    
    public PostsAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.Posts> postList, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super com.uni.unistudent.classes.Posts, kotlin.Unit> onItemClicked, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super com.uni.unistudent.classes.Posts, kotlin.Unit> onComment) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.uni.unistudent.classes.Posts> getPostList() {
        return null;
    }
    
    public final void setPostList(@org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.Posts> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function2<java.lang.Integer, com.uni.unistudent.classes.Posts, kotlin.Unit> getOnItemClicked() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function2<java.lang.Integer, com.uni.unistudent.classes.Posts, kotlin.Unit> getOnComment() {
        return null;
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void update(@org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.Posts> list) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0019\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00110\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\n \u0007*\u0004\u0018\u00010\u00150\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/uni/unistudent/adapters/PostsAdapter$ViewHolder1;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Lcom/uni/unistudent/adapters/PostsAdapter;Landroid/view/View;)V", "addComment", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "getAddComment", "()Landroid/widget/Button;", "audience", "Landroid/widget/TextView;", "getAudience", "()Landroid/widget/TextView;", "auth", "getAuth", "image", "Landroid/widget/ImageView;", "getImage", "()Landroid/widget/ImageView;", "recyItem", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRecyItem", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "text", "getText", "app_debug"})
    public final class ViewHolder1 extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.ImageView image = null;
        private final android.widget.TextView auth = null;
        private final android.widget.TextView audience = null;
        private final android.widget.TextView text = null;
        private final android.widget.Button addComment = null;
        private final androidx.constraintlayout.widget.ConstraintLayout recyItem = null;
        
        public ViewHolder1(@org.jetbrains.annotations.NotNull
        android.view.View item) {
            super(null);
        }
        
        public final android.widget.ImageView getImage() {
            return null;
        }
        
        public final android.widget.TextView getAuth() {
            return null;
        }
        
        public final android.widget.TextView getAudience() {
            return null;
        }
        
        public final android.widget.TextView getText() {
            return null;
        }
        
        public final android.widget.Button getAddComment() {
            return null;
        }
        
        public final androidx.constraintlayout.widget.ConstraintLayout getRecyItem() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/uni/unistudent/adapters/PostsAdapter$ViewHolder2;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Lcom/uni/unistudent/adapters/PostsAdapter;Landroid/view/View;)V", "audience", "Landroid/widget/TextView;", "getAudience", "()Landroid/widget/TextView;", "auth", "getAuth", "itemComments", "Landroid/widget/LinearLayout;", "getItemComments", "()Landroid/widget/LinearLayout;", "postItem", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getPostItem", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "text", "getText", "app_debug"})
    final class ViewHolder2 extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView auth = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView audience = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView text = null;
        @org.jetbrains.annotations.NotNull
        private final androidx.constraintlayout.widget.ConstraintLayout postItem = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.LinearLayout itemComments = null;
        
        public ViewHolder2(@org.jetbrains.annotations.NotNull
        android.view.View item) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getAuth() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getAudience() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getText() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final androidx.constraintlayout.widget.ConstraintLayout getPostItem() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.LinearLayout getItemComments() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/uni/unistudent/adapters/PostsAdapter$Companion;", "", "()V", "WITHOUT_IMAGE", "", "WITH_IMAGE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}