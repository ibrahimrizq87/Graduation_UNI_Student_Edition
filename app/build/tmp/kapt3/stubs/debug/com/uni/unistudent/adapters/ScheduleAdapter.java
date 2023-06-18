package com.uni.unistudent.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003&\'(BO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\u0002\u0010\rJ\b\u0010\u0017\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\nH\u0016J\u0014\u0010$\u001a\u00020\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R#\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015\u00a8\u0006)"}, d2 = {"Lcom/uni/unistudent/adapters/ScheduleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "dataList", "", "Lcom/uni/unistudent/classes/ScheduleDataType;", "onItemClicked", "Lkotlin/Function2;", "", "", "onAttendClicked", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getContext", "()Landroid/content/Context;", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "getOnAttendClicked", "()Lkotlin/jvm/functions/Function2;", "getOnItemClicked", "getItemCount", "getItemViewType", "position", "getTime12h", "", "time", "getTypeTime", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "list", "Companion", "ViewHolder1", "ViewHolder2", "app_debug"})
public final class ScheduleAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.uni.unistudent.classes.ScheduleDataType> dataList;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function2<java.lang.Integer, com.uni.unistudent.classes.ScheduleDataType, kotlin.Unit> onItemClicked = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function2<java.lang.Integer, com.uni.unistudent.classes.ScheduleDataType, kotlin.Unit> onAttendClicked = null;
    @org.jetbrains.annotations.NotNull
    public static final com.uni.unistudent.adapters.ScheduleAdapter.Companion Companion = null;
    public static final int VIEW_TYPE_ONE = 1;
    public static final int VIEW_TYPE_TWO = 2;
    
    public ScheduleAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.ScheduleDataType> dataList, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super com.uni.unistudent.classes.ScheduleDataType, kotlin.Unit> onItemClicked, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super com.uni.unistudent.classes.ScheduleDataType, kotlin.Unit> onAttendClicked) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.uni.unistudent.classes.ScheduleDataType> getDataList() {
        return null;
    }
    
    public final void setDataList(@org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.ScheduleDataType> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function2<java.lang.Integer, com.uni.unistudent.classes.ScheduleDataType, kotlin.Unit> getOnItemClicked() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function2<java.lang.Integer, com.uni.unistudent.classes.ScheduleDataType, kotlin.Unit> getOnAttendClicked() {
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
    java.util.List<com.uni.unistudent.classes.ScheduleDataType> list) {
    }
    
    private final java.lang.String getTypeTime(java.lang.String time) {
        return null;
    }
    
    private final java.lang.String getTime12h(java.lang.String time) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0019\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0019\u0010\u0014\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\u0019\u0010\u0015\u001a\n \u0007*\u0004\u0018\u00010\u00160\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0017R\u0019\u0010\u0018\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\u0019\u0010\u001a\u001a\n \u0007*\u0004\u0018\u00010\u001b0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\t\u00a8\u0006 "}, d2 = {"Lcom/uni/unistudent/adapters/ScheduleAdapter$ViewHolder1;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Lcom/uni/unistudent/adapters/ScheduleAdapter;Landroid/view/View;)V", "amPm_sec", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getAmPm_sec", "()Landroid/widget/TextView;", "assistant", "getAssistant", "attend", "Landroidx/cardview/widget/CardView;", "getAttend", "()Landroidx/cardview/widget/CardView;", "courseName", "getCourseName", "from", "getFrom", "isRunning", "isRunning_img", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "location", "getLocation", "recyItem", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRecyItem", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "to", "getTo", "app_debug"})
    public final class ViewHolder1 extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView isRunning = null;
        private final android.widget.ImageView isRunning_img = null;
        private final android.widget.TextView courseName = null;
        private final android.widget.TextView location = null;
        private final android.widget.TextView assistant = null;
        private final android.widget.TextView from = null;
        private final android.widget.TextView to = null;
        private final android.widget.TextView amPm_sec = null;
        private final androidx.cardview.widget.CardView attend = null;
        private final androidx.constraintlayout.widget.ConstraintLayout recyItem = null;
        
        public ViewHolder1(@org.jetbrains.annotations.NotNull
        android.view.View item) {
            super(null);
        }
        
        public final android.widget.TextView isRunning() {
            return null;
        }
        
        public final android.widget.ImageView isRunning_img() {
            return null;
        }
        
        public final android.widget.TextView getCourseName() {
            return null;
        }
        
        public final android.widget.TextView getLocation() {
            return null;
        }
        
        public final android.widget.TextView getAssistant() {
            return null;
        }
        
        public final android.widget.TextView getFrom() {
            return null;
        }
        
        public final android.widget.TextView getTo() {
            return null;
        }
        
        public final android.widget.TextView getAmPm_sec() {
            return null;
        }
        
        public final androidx.cardview.widget.CardView getAttend() {
            return null;
        }
        
        public final androidx.constraintlayout.widget.ConstraintLayout getRecyItem() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0019\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0019\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u0019\u0010\u0013\u001a\n \u0007*\u0004\u0018\u00010\u00140\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0015R\u0019\u0010\u0016\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u0019\u0010\u0018\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\u0019\u0010\u001a\u001a\n \u0007*\u0004\u0018\u00010\u001b0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\t\u00a8\u0006 "}, d2 = {"Lcom/uni/unistudent/adapters/ScheduleAdapter$ViewHolder2;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Lcom/uni/unistudent/adapters/ScheduleAdapter;Landroid/view/View;)V", "amPm_lec", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getAmPm_lec", "()Landroid/widget/TextView;", "attend_lec", "Landroidx/cardview/widget/CardView;", "getAttend_lec", "()Landroidx/cardview/widget/CardView;", "course_name_lec", "getCourse_name_lec", "from_lec", "getFrom_lec", "isRunning", "isRunning_img", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "lecturer", "getLecturer", "location_lec", "getLocation_lec", "recyItem", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRecyItem", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "to_lec", "getTo_lec", "app_debug"})
    final class ViewHolder2 extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView isRunning = null;
        private final android.widget.ImageView isRunning_img = null;
        private final android.widget.TextView course_name_lec = null;
        private final android.widget.TextView location_lec = null;
        private final android.widget.TextView lecturer = null;
        private final android.widget.TextView from_lec = null;
        private final android.widget.TextView to_lec = null;
        private final android.widget.TextView amPm_lec = null;
        private final androidx.cardview.widget.CardView attend_lec = null;
        private final androidx.constraintlayout.widget.ConstraintLayout recyItem = null;
        
        public ViewHolder2(@org.jetbrains.annotations.NotNull
        android.view.View item) {
            super(null);
        }
        
        public final android.widget.TextView isRunning() {
            return null;
        }
        
        public final android.widget.ImageView isRunning_img() {
            return null;
        }
        
        public final android.widget.TextView getCourse_name_lec() {
            return null;
        }
        
        public final android.widget.TextView getLocation_lec() {
            return null;
        }
        
        public final android.widget.TextView getLecturer() {
            return null;
        }
        
        public final android.widget.TextView getFrom_lec() {
            return null;
        }
        
        public final android.widget.TextView getTo_lec() {
            return null;
        }
        
        public final android.widget.TextView getAmPm_lec() {
            return null;
        }
        
        public final androidx.cardview.widget.CardView getAttend_lec() {
            return null;
        }
        
        public final androidx.constraintlayout.widget.ConstraintLayout getRecyItem() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/uni/unistudent/adapters/ScheduleAdapter$Companion;", "", "()V", "VIEW_TYPE_ONE", "", "VIEW_TYPE_TWO", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}