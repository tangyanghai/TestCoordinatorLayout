package com.tyh.java.myapplication.nestedScroll.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent2;
import android.support.v4.view.NestedScrollingParentHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.tyh.java.myapplication.R;
import com.tyh.java.myapplication.coordinatorLayout.appbar.ViewOffsetHelper;
import com.tyh.java.myapplication.utils.LogUtils;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/7
 * 描述:
 */
public class NestedParent extends LinearLayout implements NestedScrollingParent2 {

    ViewOffsetHelper mViewOffsetHelper;

    private NestedScrollingParentHelper mHelper;

    public NestedParent(Context context) {
        this(context, null);
    }

    public NestedParent(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mHelper = new NestedScrollingParentHelper(this);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

    }

    @Override
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view1, int i, int i1) {
        LogUtils.logMethod();
        return true;
    }

    @Override
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view1, int i, int i1) {
        LogUtils.logMethod();
    }

    @Override
    public void onStopNestedScroll(@NonNull View view, int i) {
        LogUtils.logMethod();
    }

    @Override
    public void onNestedScroll(@NonNull View view, int i, int i1, int i2, int i3, int i4) {
        LogUtils.logMethod();
        mViewOffsetHelper.setTopAndBottomOffset(mViewOffsetHelper.getTopAndBottomOffset() + 2*i1);
    }

    @Override
    public void onNestedPreScroll(@NonNull View view, int i, int i1, @NonNull int[] ints, int i2) {
        LogUtils.logMethod();
        mViewOffsetHelper.setTopAndBottomOffset(mViewOffsetHelper.getTopAndBottomOffset() - 2*i1);
        ints[1] = 5*i1;
    }
}
