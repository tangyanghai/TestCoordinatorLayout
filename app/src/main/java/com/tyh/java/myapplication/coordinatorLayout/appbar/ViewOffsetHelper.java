package com.tyh.java.myapplication.coordinatorLayout.appbar;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewTreeObserver;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/6
 * 描述:
 * <p>这是一个上下左右移动view的帮助类</p>
 * <p>上下移动  {@link #setTopAndBottomOffset(int)}</p>
 * <p>左右移动  {@link #setLeftAndRightOffset(int)}</p>
 */
public class ViewOffsetHelper {

    private final View view;
    private int layoutTop;
    private int layoutLeft;
    private int offsetTop;
    private int offsetLeft;

    public ViewOffsetHelper(View view) {
        this.view = view;
    }

    /**
     * 当{@link View#getViewTreeObserver()  }
     * {@link android.view.ViewTreeObserver#addOnGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener)}
     */
    public void onViewLayout() {
        this.layoutTop = view.getTop();
        this.layoutLeft = view.getLeft();
    }

    public void updateOffsets() {
        ViewCompat.offsetTopAndBottom(view, this.offsetTop - (view.getTop() - this.layoutTop));
        ViewCompat.offsetLeftAndRight(view, this.offsetLeft - (view.getLeft() - this.layoutLeft));
    }

    public boolean setTopAndBottomOffset(int offset) {

        if (this.offsetTop != offset) {
            this.offsetTop = offset;
            this.updateOffsets();
            return true;
        }

        return false;
    }

    public boolean setLeftAndRightOffset(int offset) {

        if (this.offsetLeft != offset) {
            this.offsetLeft = offset;
            this.updateOffsets();
            return true;
        }

        return false;
    }

    public int getTopAndBottomOffset() {
        return offsetTop;
    }

    public int getLeftAndRightOffset() {
        return offsetLeft;
    }

    public int getLayoutTop() {
        return layoutTop;
    }

    public int getLayoutLeft() {
        return layoutLeft;
    }
}
