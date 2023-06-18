// Generated by data binding compiler. Do not edit!
package com.uni.unistudent.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.uni.unistudent.R;
import com.uni.unistudent.classes.user.UserStudent;
import com.uni.unistudent.viewModel.FireStorageViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentProfileBinding extends ViewDataBinding {
  @NonNull
  public final TextView fragmentName;

  @NonNull
  public final ShapeableImageView imageProfile;

  @NonNull
  public final ProgressBar progressBarProfile;

  @NonNull
  public final RecyclerView recyclerMatchLeague;

  @NonNull
  public final LinearLayout studentData;

  @NonNull
  public final SwipeRefreshLayout swipeRefreshLayout;

  @NonNull
  public final TextView textCourses;

  @NonNull
  public final TextView textDepartmentName;

  @NonNull
  public final TextView textGrade;

  @NonNull
  public final TextView textSection;

  @NonNull
  public final TextView textStudentName;

  @NonNull
  public final TextView textUserid;

  @Bindable
  protected UserStudent mUser;

  @Bindable
  protected FireStorageViewModel mStorageViewModel;

  protected FragmentProfileBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView fragmentName, ShapeableImageView imageProfile, ProgressBar progressBarProfile,
      RecyclerView recyclerMatchLeague, LinearLayout studentData,
      SwipeRefreshLayout swipeRefreshLayout, TextView textCourses, TextView textDepartmentName,
      TextView textGrade, TextView textSection, TextView textStudentName, TextView textUserid) {
    super(_bindingComponent, _root, _localFieldCount);
    this.fragmentName = fragmentName;
    this.imageProfile = imageProfile;
    this.progressBarProfile = progressBarProfile;
    this.recyclerMatchLeague = recyclerMatchLeague;
    this.studentData = studentData;
    this.swipeRefreshLayout = swipeRefreshLayout;
    this.textCourses = textCourses;
    this.textDepartmentName = textDepartmentName;
    this.textGrade = textGrade;
    this.textSection = textSection;
    this.textStudentName = textStudentName;
    this.textUserid = textUserid;
  }

  public abstract void setUser(@Nullable UserStudent user);

  @Nullable
  public UserStudent getUser() {
    return mUser;
  }

  public abstract void setStorageViewModel(@Nullable FireStorageViewModel storageViewModel);

  @Nullable
  public FireStorageViewModel getStorageViewModel() {
    return mStorageViewModel;
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_profile, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentProfileBinding>inflateInternal(inflater, R.layout.fragment_profile, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_profile, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentProfileBinding>inflateInternal(inflater, R.layout.fragment_profile, null, false, component);
  }

  public static FragmentProfileBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentProfileBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentProfileBinding)bind(component, view, R.layout.fragment_profile);
  }
}
