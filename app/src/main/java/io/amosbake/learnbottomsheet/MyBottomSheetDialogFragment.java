package io.amosbake.learnbottomsheet;

import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;

/**
 * Author: mopel
 * Date : 2016/4/29
 */
public class MyBottomSheetDialogFragment extends BottomSheetDialogFragment {
  private  BottomSheetBehavior.BottomSheetCallback callback = new BottomSheetBehavior.BottomSheetCallback() {
    @Override public void onStateChanged(@NonNull View bottomSheet, int newState) {
      if (newState == BottomSheetBehavior.STATE_HIDDEN) {
        dismiss();
      }
    }
    @Override public void onSlide(@NonNull View bottomSheet, float slideOffset) {

    }
  };


  @Override public void setupDialog(Dialog dialog, int style) {
    super.setupDialog(dialog, style);
    View contentView = View.inflate(getContext(),R.layout.dialog_bottom_sheet,null);
    dialog.setContentView(contentView);
    CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) contentView.getParent()).getLayoutParams();
    CoordinatorLayout.Behavior behavior = params.getBehavior();

    if( behavior != null && behavior instanceof BottomSheetBehavior ) {
      ((BottomSheetBehavior) behavior).setBottomSheetCallback(callback);
    }
  }
}
