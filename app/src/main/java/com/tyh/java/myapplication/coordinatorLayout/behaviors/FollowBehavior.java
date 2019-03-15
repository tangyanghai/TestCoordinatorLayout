package com.tyh.java.myapplication.coordinatorLayout.behaviors;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * 创建人: tyh
 * 创建时间: 2019/2/27
 * 描述:跟随移动的按钮
 * 跟随条件:  跟随tag相同的那个控件进行移动
 */
public class FollowBehavior extends CoordinatorLayout.Behavior {

    public FollowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        return dependency.getTag() != null && child.getTag() != null && dependency.getTag().equals(child.getTag());
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        child.setX(dependency.getX());
        child.setY(dependency.getY() + 100);
        return super.onDependentViewChanged(parent, child, dependency);
    }

}
