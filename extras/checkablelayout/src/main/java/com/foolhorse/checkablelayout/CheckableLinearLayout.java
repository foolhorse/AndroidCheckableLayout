package com.foolhorse.checkablelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;

public class CheckableLinearLayout extends LinearLayout implements Checkable {


    private OnCheckedChangeListener mOnCheckedChangeListener;

    private boolean mChecked = false;

    private static final int[] CHECKED_STATE_SET = {android.R.attr.state_checked};


    public CheckableLinearLayout(Context context) {
        super(context);
    }

    public CheckableLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void setChecked(boolean checked) {
        if (mChecked == checked) {
            return;
        }
        mChecked = checked;
        changeCheckState();
        dispatchSetChecked(mChecked);
    }

    @Override
    public void toggle() {
        mChecked = !mChecked;
        changeCheckState();
        dispatchSetChecked(mChecked);
    }

    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
    }

    private void changeCheckState() {
        refreshDrawableState();

        if (mOnCheckedChangeListener != null) {
            mOnCheckedChangeListener.onCheckedChanged(this, mChecked);
        }
    }

    public void dispatchSetChecked(boolean checked) {
        for (int i = 0; i < getChildCount(); i++) {
            if(getChildAt(i) instanceof Checkable){
                ((Checkable)getChildAt(i)).setChecked(checked);
            }
        }
    }

}