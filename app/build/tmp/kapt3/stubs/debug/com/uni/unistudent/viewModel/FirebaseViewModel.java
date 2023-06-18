package com.uni.unistudent.viewModel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\bJ\u0016\u00103\u001a\u00020/2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\bJ\u001e\u00104\u001a\u00020/2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\b2\u0006\u00105\u001a\u00020\bJ&\u00106\u001a\u00020/2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bJ\u001e\u00109\u001a\u00020/2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\bJ\u0016\u0010:\u001a\u00020/2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\bJ\u001e\u0010;\u001a\u00020/2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\b2\u0006\u00105\u001a\u00020\bJ&\u0010<\u001a\u00020/2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bJ\u0014\u0010\u001e\u001a\u00020/2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000f0\nJ\u0016\u0010>\u001a\u00020/2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\bJ\u000e\u0010?\u001a\u00020/2\u0006\u00101\u001a\u00020\bJ\u0016\u0010@\u001a\u00020/2\u0006\u00101\u001a\u00020\b2\u0006\u00105\u001a\u00020\bJ\u001e\u0010A\u001a\u00020/2\u0006\u00101\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bJ\u000e\u0010\"\u001a\u00020/2\u0006\u0010B\u001a\u00020\bJ\u001c\u0010$\u001a\u00020C2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u00108\u001a\u00020\bJ\u000e\u0010&\u001a\u00020/2\u0006\u00105\u001a\u00020\bJ,\u0010(\u001a\u00020/2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u0010D\u001a\u00020\bJ\u0014\u0010*\u001a\u00020/2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000f0\nJ$\u0010,\u001a\u00020/2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u00108\u001a\u00020\b2\u0006\u00107\u001a\u00020\bJ\u001e\u0010E\u001a\u00020/2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\bJ\u0016\u0010F\u001a\u00020/2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\bJ\u001e\u0010G\u001a\u00020/2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\b2\u0006\u00105\u001a\u00020\bJ&\u0010H\u001a\u00020/2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bR\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\n\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\n\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\n\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR%\u0010\u001e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR%\u0010 \u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n\u0018\u00010\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR%\u0010\"\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\n\u0018\u00010\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR%\u0010$\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n\u0018\u00010\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR!\u0010&\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001dR%\u0010(\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\n\u0018\u00010\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR%\u0010*\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n\u0018\u00010\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR%\u0010,\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\n\u0018\u00010\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2 = {"Lcom/uni/unistudent/viewModel/FirebaseViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/uni/unistudent/data/FirebaseRepo;", "(Lcom/uni/unistudent/data/FirebaseRepo;)V", "_addCommentGeneral", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/uni/unistudent/data/Resource;", "", "_getAssistant", "", "Lcom/uni/unistudent/classes/Assistant;", "_getCommentGeneral", "Lcom/uni/unistudent/classes/Comment;", "_getCourses", "Lcom/uni/unistudent/classes/Courses;", "_getLecture", "Lcom/uni/unistudent/classes/Lecture;", "_getPermission", "Lcom/uni/unistudent/classes/Permission;", "_getPosts", "Lcom/uni/unistudent/classes/Posts;", "_getProfessor", "Lcom/uni/unistudent/classes/Professor;", "_getSection", "Lcom/uni/unistudent/classes/Section;", "addCommentGeneral", "Lkotlinx/coroutines/flow/StateFlow;", "getAddCommentGeneral", "()Lkotlinx/coroutines/flow/StateFlow;", "getAssistant", "getGetAssistant", "getCommentGeneral", "getGetCommentGeneral", "getCourses", "getGetCourses", "getLecture", "getGetLecture", "getPermission", "getGetPermission", "getPosts", "getGetPosts", "getProfessor", "getGetProfessor", "getSection", "getGetSection", "addCommentsCourse", "Lkotlinx/coroutines/Job;", "comment", "postID", "courseID", "addCommentsGeneral", "addCommentsPersonal", "userId", "addCommentsSection", "section", "dep", "deleteCommentsCourse", "deleteCommentsGeneral", "deleteCommentsPersonal", "deleteCommentsSection", "courses", "getCommentsCourse", "getCommentsGeneral", "getCommentsPersonal", "getCommentsSection", "grade", "", "userID", "updateCommentsCourse", "updateCommentsGeneral", "updateCommentsPersonal", "updateCommentsSection", "app_debug"})
public final class FirebaseViewModel extends androidx.lifecycle.ViewModel {
    private final com.uni.unistudent.data.FirebaseRepo repository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Courses>>> _getCourses = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Courses>>> getCourses = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.uni.unistudent.data.Resource<com.uni.unistudent.classes.Permission>> _getPermission = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<com.uni.unistudent.classes.Permission>> getPermission = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Professor>>> _getProfessor = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Professor>>> getProfessor = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Assistant>>> _getAssistant = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Assistant>>> getAssistant = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Section>>> _getSection = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Section>>> getSection = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Lecture>>> _getLecture = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Lecture>>> getLecture = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Posts>>> _getPosts = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Posts>>> getPosts = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Comment>>> _getCommentGeneral = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Comment>>> getCommentGeneral = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.uni.unistudent.data.Resource<java.lang.String>> _addCommentGeneral = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.lang.String>> addCommentGeneral = null;
    
    @javax.inject.Inject
    public FirebaseViewModel(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.data.FirebaseRepo repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job updateCommentsPersonal(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.Comment comment, @org.jetbrains.annotations.NotNull
    java.lang.String postID, @org.jetbrains.annotations.NotNull
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job updateCommentsGeneral(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.Comment comment, @org.jetbrains.annotations.NotNull
    java.lang.String postID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job updateCommentsSection(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.Comment comment, @org.jetbrains.annotations.NotNull
    java.lang.String postID, @org.jetbrains.annotations.NotNull
    java.lang.String section, @org.jetbrains.annotations.NotNull
    java.lang.String dep) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job updateCommentsCourse(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.Comment comment, @org.jetbrains.annotations.NotNull
    java.lang.String postID, @org.jetbrains.annotations.NotNull
    java.lang.String courseID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job deleteCommentsPersonal(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.Comment comment, @org.jetbrains.annotations.NotNull
    java.lang.String postID, @org.jetbrains.annotations.NotNull
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job deleteCommentsGeneral(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.Comment comment, @org.jetbrains.annotations.NotNull
    java.lang.String postID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job deleteCommentsSection(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.Comment comment, @org.jetbrains.annotations.NotNull
    java.lang.String postID, @org.jetbrains.annotations.NotNull
    java.lang.String section, @org.jetbrains.annotations.NotNull
    java.lang.String dep) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job deleteCommentsCourse(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.Comment comment, @org.jetbrains.annotations.NotNull
    java.lang.String postID, @org.jetbrains.annotations.NotNull
    java.lang.String courseID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Courses>>> getGetCourses() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<com.uni.unistudent.classes.Permission>> getGetPermission() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Professor>>> getGetProfessor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Assistant>>> getGetAssistant() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Section>>> getGetSection() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Lecture>>> getGetLecture() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Posts>>> getGetPosts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getPosts(@org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.Courses> courses, @org.jetbrains.annotations.NotNull
    java.lang.String section, @org.jetbrains.annotations.NotNull
    java.lang.String dep, @org.jetbrains.annotations.NotNull
    java.lang.String userID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.util.List<com.uni.unistudent.classes.Comment>>> getGetCommentGeneral() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.uni.unistudent.data.Resource<java.lang.String>> getAddCommentGeneral() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getCommentsPersonal(@org.jetbrains.annotations.NotNull
    java.lang.String postID, @org.jetbrains.annotations.NotNull
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getCommentsGeneral(@org.jetbrains.annotations.NotNull
    java.lang.String postID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getCommentsSection(@org.jetbrains.annotations.NotNull
    java.lang.String postID, @org.jetbrains.annotations.NotNull
    java.lang.String section, @org.jetbrains.annotations.NotNull
    java.lang.String dep) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getCommentsCourse(@org.jetbrains.annotations.NotNull
    java.lang.String postID, @org.jetbrains.annotations.NotNull
    java.lang.String courseID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job addCommentsPersonal(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.Comment comment, @org.jetbrains.annotations.NotNull
    java.lang.String postID, @org.jetbrains.annotations.NotNull
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job addCommentsGeneral(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.Comment comment, @org.jetbrains.annotations.NotNull
    java.lang.String postID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job addCommentsSection(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.Comment comment, @org.jetbrains.annotations.NotNull
    java.lang.String postID, @org.jetbrains.annotations.NotNull
    java.lang.String section, @org.jetbrains.annotations.NotNull
    java.lang.String dep) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job addCommentsCourse(@org.jetbrains.annotations.NotNull
    com.uni.unistudent.classes.Comment comment, @org.jetbrains.annotations.NotNull
    java.lang.String postID, @org.jetbrains.annotations.NotNull
    java.lang.String courseID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getPermission(@org.jetbrains.annotations.NotNull
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getCourses(@org.jetbrains.annotations.NotNull
    java.lang.String grade) {
        return null;
    }
    
    public final void getLecture(@org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.Courses> courses, @org.jetbrains.annotations.NotNull
    java.lang.String dep) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getSection(@org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.Courses> courses, @org.jetbrains.annotations.NotNull
    java.lang.String dep, @org.jetbrains.annotations.NotNull
    java.lang.String section) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getProfessor(@org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.Courses> courses) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getAssistant(@org.jetbrains.annotations.NotNull
    java.util.List<com.uni.unistudent.classes.Courses> courses) {
        return null;
    }
}