package com.tyh.java.myapplication.coordinatorLayout.behaviors;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.tyh.java.myapplication.R;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/4
 * 描述:
 */
public class ScaleBehavior extends CoordinatorLayout.Behavior {
    public ScaleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        boolean b = dependency instanceof AppBarLayout;
        return b;
    }

    private int maxHeight;
    private ScaleHolder mScaleHolder;
    private int minBottom;
    private ViewHelper mViewHelper;

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {

        if (maxHeight <= 0) {
            mViewHelper = new ViewHelper(child);
            maxHeight = ((AppBarLayout) dependency).getTotalScrollRange();
            minBottom = parent.findViewById(R.id.title).getBottom();
            mScaleHolder = new ScaleHolder(maxHeight / 3, maxHeight);
            Log.e("===", "minBottom = " + minBottom);
        }

        if (maxHeight > 0) {
            float scale = mScaleHolder.calScale(dependency.getBottom() - minBottom);
            mViewHelper.scale(scale, scale)
                    .moveToCenter((int) (dependency.getX() / 2 + dependency.getMeasuredWidth() / 2),
                            dependency.getBottom() / 2 - minBottom / 2 + minBottom
                    );
        }

        return super.onDependentViewChanged(parent, child, dependency);
    }

    class ScaleHolder {
        int minPoint;
        int maxPoint;

        public ScaleHolder(int minPoint, int maxPoint) {
            this.minPoint = minPoint;
            this.maxPoint = maxPoint;
        }

        float calScale(int curHeight) {
            float v = 1.0f * curHeight / maxHeight;
            return v >= 1 ? 1 : v > 0 ? v : 0;
        }
    }


}
