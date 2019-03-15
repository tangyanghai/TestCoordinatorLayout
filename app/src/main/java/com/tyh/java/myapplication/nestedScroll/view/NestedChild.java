package com.tyh.java.myapplication.nestedScroll.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingChild2;
import android.support.v4.view.NestedScrollingChildHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.tyh.java.myapplication.coordinatorLayout.appbar.ViewOffsetHelper;
import com.tyh.java.myapplication.utils.LogUtils;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/7
 * 描述:
 */
public class NestedChild extends LinearLayout implements NestedScrollingChild2 {

    NestedScrollingChildHelper mHelper;
    ViewOffsetHelper mViewOffsetHelper;


    public NestedChild(Context context) {
        this(context, null);
    }

    public NestedChild(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mHelper = new NestedScrollingChildHelper(this);
        mHelper.setNestedScrollingEnabled(true);
        mViewOffsetHelper = new ViewOffsetHelper(this);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mViewOffsetHelper.onViewLayout();
    }

    boolean accepted;
    int lastY;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        accepted = super.onTouchEvent(e);
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                accepted = true;
                lastY = (int) e.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                accepted = true;
                if (startNestedScroll(SCROLL_AXIS_VERTICAL, 0)) {
                    dispatchNestedPreScroll(0, (int) e.getRawY() - lastY, new int[2], new int[2], 0);
                    lastY = (int) e.getRawY();
                }
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                break;
        }

        return accepted;
    }

    @Override
    public boolean startNestedScroll(int i, int i1) {
        boolean b = mHelper.startNestedScroll(i, i1);
        LogUtils.logWithMethod("b = " + b);
        return b;
    }

    @Override
    public void stopNestedScroll(int i) {
        LogUtils.logMethod();
        mHelper.stopNestedScroll(i);
    }

    @Override
    public boolean hasNestedScrollingParent(int i) {
        boolean b = mHelper.hasNestedScrollingParent(i);
        LogUtils.logWithMethod("b = " + b);
        return b;
    }

    @Override
    public boolean dispatchNestedPreScroll(int i, int i1, @Nullable int[] ints, @Nullable int[] ints1, int i2) {
        boolean b = mHelper.dispatchNestedPreScroll(i, i1, ints, ints1, i2);
        if (mViewOffsetHelper.getTopAndBottomOffset() > 100) {
            dispatchNestedScroll(i, i1, i, i1, ints, i2);
        } else {
            mViewOffsetHelper.setTopAndBottomOffset(mViewOffsetHelper.getTopAndBottomOffset() + ints[1]);
        }
        LogUtils.logWithMethod("b = " + b);
        return b;
    }

    @Override
    public boolean dispatchNestedScroll(int i, int i1, int i2, int i3, @Nullable int[] ints, int i4) {
        boolean b = mHelper.dispatchNestedScroll(i, i1, i2, i3, ints, i4);
        if (mViewOffsetHelper.getTopAndBottomOffset() > 50) {
            mViewOffsetHelper.setTopAndBottomOffset(mViewOffsetHelper.getTopAndBottomOffset() - ints[1]);
        }
        LogUtils.logWithMethod("b = " + b);
        return b;
    }

}
