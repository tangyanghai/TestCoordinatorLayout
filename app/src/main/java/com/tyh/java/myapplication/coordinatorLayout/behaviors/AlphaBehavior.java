package com.tyh.java.myapplication.coordinatorLayout.behaviors;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/4
 * 描述:
 */
public class AlphaBehavior extends CoordinatorLayout.Behavior {


    public AlphaBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {

        boolean b = dependency instanceof AppBarLayout;

        return b;
    }

    private int maxHeight;
    private int height;

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        if (maxHeight <= 0) {
            maxHeight = ((AppBarLayout) dependency).getTotalScrollRange();
        }

        if (height <= 0) {
            height = child.getMeasuredHeight();
        }
        Log.e("===", "maxHeight =" + maxHeight + ";height = " + height);
        if (maxHeight > 0 && height > 0) {
            float alpha = Math.abs(1 - (dependency.getBottom() * 1.0f - height) / maxHeight);
            Log.e("===", "alpha =" + alpha);
            child.setAlpha(alpha);
        }
        return super.onDependentViewChanged(parent, child, dependency);
    }

}
