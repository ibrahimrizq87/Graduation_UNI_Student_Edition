package com.uni.unistudent;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.uni.unistudent.databinding.ActivityHomeScreenBindingImpl;
import com.uni.unistudent.databinding.ActivityScanBindingImpl;
import com.uni.unistudent.databinding.FragmentCommentBindingImpl;
import com.uni.unistudent.databinding.FragmentProfileBindingImpl;
import com.uni.unistudent.databinding.FragmentScheduleBindingImpl;
import com.uni.unistudent.databinding.ItemProfileCourseBindingImpl;
import com.uni.unistudent.databinding.RecyclerDaysViewBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYHOMESCREEN = 1;

  private static final int LAYOUT_ACTIVITYSCAN = 2;

  private static final int LAYOUT_FRAGMENTCOMMENT = 3;

  private static final int LAYOUT_FRAGMENTPROFILE = 4;

  private static final int LAYOUT_FRAGMENTSCHEDULE = 5;

  private static final int LAYOUT_ITEMPROFILECOURSE = 6;

  private static final int LAYOUT_RECYCLERDAYSVIEW = 7;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(7);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.uni.unistudent.R.layout.activity_home_screen, LAYOUT_ACTIVITYHOMESCREEN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.uni.unistudent.R.layout.activity_scan, LAYOUT_ACTIVITYSCAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.uni.unistudent.R.layout.fragment_comment, LAYOUT_FRAGMENTCOMMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.uni.unistudent.R.layout.fragment_profile, LAYOUT_FRAGMENTPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.uni.unistudent.R.layout.fragment_schedule, LAYOUT_FRAGMENTSCHEDULE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.uni.unistudent.R.layout.item_profile_course, LAYOUT_ITEMPROFILECOURSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.uni.unistudent.R.layout.recycler_days_view, LAYOUT_RECYCLERDAYSVIEW);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYHOMESCREEN: {
          if ("layout/activity_home_screen_0".equals(tag)) {
            return new ActivityHomeScreenBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_home_screen is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSCAN: {
          if ("layout/activity_scan_0".equals(tag)) {
            return new ActivityScanBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_scan is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCOMMENT: {
          if ("layout/fragment_comment_0".equals(tag)) {
            return new FragmentCommentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_comment is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPROFILE: {
          if ("layout/fragment_profile_0".equals(tag)) {
            return new FragmentProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSCHEDULE: {
          if ("layout/fragment_schedule_0".equals(tag)) {
            return new FragmentScheduleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_schedule is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMPROFILECOURSE: {
          if ("layout/item_profile_course_0".equals(tag)) {
            return new ItemProfileCourseBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_profile_course is invalid. Received: " + tag);
        }
        case  LAYOUT_RECYCLERDAYSVIEW: {
          if ("layout/recycler_days_view_0".equals(tag)) {
            return new RecyclerDaysViewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for recycler_days_view is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "course");
      sKeys.put(2, "storageViewModel");
      sKeys.put(3, "user");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(7);

    static {
      sKeys.put("layout/activity_home_screen_0", com.uni.unistudent.R.layout.activity_home_screen);
      sKeys.put("layout/activity_scan_0", com.uni.unistudent.R.layout.activity_scan);
      sKeys.put("layout/fragment_comment_0", com.uni.unistudent.R.layout.fragment_comment);
      sKeys.put("layout/fragment_profile_0", com.uni.unistudent.R.layout.fragment_profile);
      sKeys.put("layout/fragment_schedule_0", com.uni.unistudent.R.layout.fragment_schedule);
      sKeys.put("layout/item_profile_course_0", com.uni.unistudent.R.layout.item_profile_course);
      sKeys.put("layout/recycler_days_view_0", com.uni.unistudent.R.layout.recycler_days_view);
    }
  }
}
