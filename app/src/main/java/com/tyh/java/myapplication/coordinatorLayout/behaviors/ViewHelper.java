package com.tyh.java.myapplication.coordinatorLayout.behaviors;

import android.view.View;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/5
 * 描述:
 */
public class ViewHelper {
    View v;

    public ViewHelper(View v) {
        this.v = v;
    }

    ViewHelper scale(float scaleX, float scaleY) {
        v.setScaleX(scaleX);
        v.setScaleY(scaleY);
        return this;
    }

    ViewHelper moveToCenter(int centerX, int centerY) {
        v.setX(centerX - v.getMeasuredWidth() / 2);
        v.setY(centerY - v.getMeasuredHeight() / 2);
        return this;
    }

    ViewHelper moveTopTo(int top) {
        v.setY(top);
        return this;
    }

    ViewHelper moveBottomTo(int bottom) {
        int h = v.getMeasuredHeight();
        v.setY(bottom - h);
        return this;
    }

}
