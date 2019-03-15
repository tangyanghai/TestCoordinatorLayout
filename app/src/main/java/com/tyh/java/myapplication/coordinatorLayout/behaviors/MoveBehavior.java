package com.tyh.java.myapplication.coordinatorLayout.behaviors;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.tyh.java.myapplication.utils.LogUtils;

import java.lang.reflect.Field;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/5
 * 描述:跟随AppBarLayout滑动上下移动的behavior
 */
public class MoveBehavior extends CoordinatorLayout.Behavior {

    private int maxMoveableHeight;//AppBarLayout最大移动高度
    private int minHeight;//AppBarLayout最小高度
    private int maxHeight;//AppBarLayout最大高度
    private AppBarLayout mDependency;
    boolean pointDownInView;
    ViewHelper helper;
    private float movedScale;//已经移动的比例
    private int offset;//top偏移量

    public MoveBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        LogUtils.logMethod();
        if (dependency instanceof AppBarLayout) {
            if (mDependency == null) {
                mDependency = (AppBarLayout) dependency;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        boolean changed = false;

        LogUtils.logMethod();
        if (maxMoveableHeight <= 0) {
            maxMoveableHeight = ((AppBarLayout) dependency).getTotalScrollRange();
            maxHeight = dependency.getMeasuredHeight();
            minHeight = maxHeight - maxMoveableHeight;
            helper = new ViewHelper(child);
        }

        if (maxMoveableHeight > 0) {
            //AppBarLayout当前底部
            Object tag = child.getTag();
            if (tag == null) {
                return false;
            }

            int curBottom = dependency.getBottom();
            int movedDis = maxHeight - curBottom;
            movedScale = 1.0f * movedDis / maxMoveableHeight;
            if (tag.equals("top_in")) {
                offset = (int) (movedScale * child.getMeasuredHeight()) - child.getMeasuredHeight();
            } else if (tag.equals("bottom_in")) {
                offset = curBottom - (int) (movedScale * child.getMeasuredHeight());
            }
            helper.moveTopTo(offset);
            changed = true;
        }
        return changed;
    }

    CoordinatorLayout.LayoutParams findLayoutParams(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();

        if (layoutParams instanceof CoordinatorLayout.MarginLayoutParams) {
            return (CoordinatorLayout.LayoutParams) layoutParams;
        }

        View parent = (View) view.getParent();

        if (parent == null) {
            return null;
        }

        return findLayoutParams(parent);
    }

    boolean isClosed() {
        return movedScale >= 1f;
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull MotionEvent ev) {
        boolean b = super.onInterceptTouchEvent(parent, child, ev);

        if (ev.getAction() == 0 && isClosed()) {
            pointDownInView = parent.isPointInChildBounds(child, (int) ev.getX(), (int) ev.getY());
        } else if (ev.getAction() == 3) {
            pointDownInView = false;
        }

        //如果是移动事件,并且移动的距离手指放下的时候是在child内的,就将让AppBarLayout能够处理移动事件
        if (ev.getAction() == 2 && isClosed() && pointDownInView) {
            CoordinatorLayout.Behavior behavior = findLayoutParams(mDependency).getBehavior();
            try {
                Class<? extends CoordinatorLayout.Behavior> cls = behavior.getClass();
                Field activePointerId = cls.getSuperclass().getSuperclass().getDeclaredField("activePointerId");
                if (activePointerId != null) {
                    activePointerId.setAccessible(true);
                    activePointerId.set(behavior, 0);
                    pointDownInView = false;
                }
                b = false;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return b;
    }

}
