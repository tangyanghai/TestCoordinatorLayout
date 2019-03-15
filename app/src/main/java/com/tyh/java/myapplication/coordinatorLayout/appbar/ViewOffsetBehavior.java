package com.tyh.java.myapplication.coordinatorLayout.appbar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.util.AttributeSet;
import android.view.View;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/6
 * 描述:可移动的Behavior的顶级Behavior
 */
public class ViewOffsetBehavior<V extends View> extends Behavior<V> {
    private ViewOffsetHelper viewOffsetHelper;
    private int tempTopBottomOffset = 0;
    private int tempLeftRightOffset = 0;


    public ViewOffsetBehavior() {
        super();
    }

    public ViewOffsetBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onLayoutChild(@NonNull CoordinatorLayout parent, @NonNull V child, int layoutDirection) {
        layoutChild(parent, child, layoutDirection);

        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new ViewOffsetHelper(child);
        }

        this.viewOffsetHelper.onViewLayout();

        if (this.tempTopBottomOffset != 0) {
            this.viewOffsetHelper.setTopAndBottomOffset(this.tempTopBottomOffset);
            this.tempTopBottomOffset = 0;
        }

        if (this.tempLeftRightOffset != 0) {
            this.viewOffsetHelper.setLeftAndRightOffset(this.tempLeftRightOffset);
            this.tempLeftRightOffset = 0;
        }
        // TODO: 2019/3/6 这里return false 会怎样?
        return true;
    }

    protected void layoutChild(@NonNull CoordinatorLayout parent, @NonNull V child, int layoutDirection) {
        parent.onLayoutChild(child, layoutDirection);
    }

    public boolean setTopAndBottomOffset(int offset) {
        if (this.viewOffsetHelper != null) {
            return this.viewOffsetHelper.setTopAndBottomOffset(offset);
        } else {
            this.tempTopBottomOffset = offset;
            return false;
        }
    }

    public boolean setLeftAndRightOffset(int offset) {
        if (this.viewOffsetHelper != null) {
            return this.viewOffsetHelper.setLeftAndRightOffset(offset);
        } else {
            this.tempLeftRightOffset = offset;
            return false;
        }
    }

    public int getTopAndBottomOffset() {
        return this.viewOffsetHelper == null ? 0 : this.viewOffsetHelper.getTopAndBottomOffset();
    }

    public int getLeftAndRightOffset() {
        return this.viewOffsetHelper == null ? 0 : this.viewOffsetHelper.getLeftAndRightOffset();
    }

}
