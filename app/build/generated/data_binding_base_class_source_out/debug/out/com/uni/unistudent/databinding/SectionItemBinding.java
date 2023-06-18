// Generated by view binder compiler. Do not edit!
package com.uni.unistudent.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uni.unistudent.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SectionItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView attendCardLecture;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final TextView courseNameS;

  @NonNull
  public final TextView fromTimeTv;

  @NonNull
  public final TextView hallOrLabTv;

  @NonNull
  public final ImageView imageProfile;

  @NonNull
  public final ImageView lectureIsRunningImg;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final RelativeLayout linearLayout2;

  @NonNull
  public final LinearLayout linearLayout3;

  @NonNull
  public final TextView secIsRunning;

  @NonNull
  public final TextView sectionAssistant;

  @NonNull
  public final TextView sectionLocation;

  @NonNull
  public final ConstraintLayout sectionView;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView timeAmPmTv;

  @NonNull
  public final TextView toTimeTv;

  private SectionItemBinding(@NonNull ConstraintLayout rootView,
      @NonNull CardView attendCardLecture, @NonNull ConstraintLayout constraintLayout,
      @NonNull TextView courseNameS, @NonNull TextView fromTimeTv, @NonNull TextView hallOrLabTv,
      @NonNull ImageView imageProfile, @NonNull ImageView lectureIsRunningImg,
      @NonNull LinearLayout linearLayout, @NonNull RelativeLayout linearLayout2,
      @NonNull LinearLayout linearLayout3, @NonNull TextView secIsRunning,
      @NonNull TextView sectionAssistant, @NonNull TextView sectionLocation,
      @NonNull ConstraintLayout sectionView, @NonNull TextView textView2,
      @NonNull TextView timeAmPmTv, @NonNull TextView toTimeTv) {
    this.rootView = rootView;
    this.attendCardLecture = attendCardLecture;
    this.constraintLayout = constraintLayout;
    this.courseNameS = courseNameS;
    this.fromTimeTv = fromTimeTv;
    this.hallOrLabTv = hallOrLabTv;
    this.imageProfile = imageProfile;
    this.lectureIsRunningImg = lectureIsRunningImg;
    this.linearLayout = linearLayout;
    this.linearLayout2 = linearLayout2;
    this.linearLayout3 = linearLayout3;
    this.secIsRunning = secIsRunning;
    this.sectionAssistant = sectionAssistant;
    this.sectionLocation = sectionLocation;
    this.sectionView = sectionView;
    this.textView2 = textView2;
    this.timeAmPmTv = timeAmPmTv;
    this.toTimeTv = toTimeTv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SectionItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SectionItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.section_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SectionItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.attend_card_lecture;
      CardView attendCardLecture = ViewBindings.findChildViewById(rootView, id);
      if (attendCardLecture == null) {
        break missingId;
      }

      id = R.id.constraintLayout;
      ConstraintLayout constraintLayout = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout == null) {
        break missingId;
      }

      id = R.id.course_name_s;
      TextView courseNameS = ViewBindings.findChildViewById(rootView, id);
      if (courseNameS == null) {
        break missingId;
      }

      id = R.id.from_time_tv;
      TextView fromTimeTv = ViewBindings.findChildViewById(rootView, id);
      if (fromTimeTv == null) {
        break missingId;
      }

      id = R.id.hallOrLab_tv;
      TextView hallOrLabTv = ViewBindings.findChildViewById(rootView, id);
      if (hallOrLabTv == null) {
        break missingId;
      }

      id = R.id.image_profile;
      ImageView imageProfile = ViewBindings.findChildViewById(rootView, id);
      if (imageProfile == null) {
        break missingId;
      }

      id = R.id.lecture_is_running_img;
      ImageView lectureIsRunningImg = ViewBindings.findChildViewById(rootView, id);
      if (lectureIsRunningImg == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.linearLayout2;
      RelativeLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      id = R.id.linearLayout3;
      LinearLayout linearLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout3 == null) {
        break missingId;
      }

      id = R.id.sec_is_running;
      TextView secIsRunning = ViewBindings.findChildViewById(rootView, id);
      if (secIsRunning == null) {
        break missingId;
      }

      id = R.id.section_assistant;
      TextView sectionAssistant = ViewBindings.findChildViewById(rootView, id);
      if (sectionAssistant == null) {
        break missingId;
      }

      id = R.id.section_location;
      TextView sectionLocation = ViewBindings.findChildViewById(rootView, id);
      if (sectionLocation == null) {
        break missingId;
      }

      ConstraintLayout sectionView = (ConstraintLayout) rootView;

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.time_AmPm_tv;
      TextView timeAmPmTv = ViewBindings.findChildViewById(rootView, id);
      if (timeAmPmTv == null) {
        break missingId;
      }

      id = R.id.to_time_tv;
      TextView toTimeTv = ViewBindings.findChildViewById(rootView, id);
      if (toTimeTv == null) {
        break missingId;
      }

      return new SectionItemBinding((ConstraintLayout) rootView, attendCardLecture,
          constraintLayout, courseNameS, fromTimeTv, hallOrLabTv, imageProfile, lectureIsRunningImg,
          linearLayout, linearLayout2, linearLayout3, secIsRunning, sectionAssistant,
          sectionLocation, sectionView, textView2, timeAmPmTv, toTimeTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
