package com.tyh.java.myapplication.coordinatorLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.tyh.java.myapplication.R;

/**
 * 创建人: tyh
 * 创建时间: 2019/2/27
 * 描述:
 */
public class FollowMovingActivity extends AppCompatActivity implements View.OnTouchListener {
    boolean get;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving_button);
        TextView tvSrc = findViewById(R.id.tv_src);
        tvSrc.setOnTouchListener(this);
        TextView tvSrc2 = findViewById(R.id.tv_src_2);
        tvSrc2.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                get = true;
                break;
            case MotionEvent.ACTION_MOVE:
                get = true;
                v.setX(v.getX() + event.getX());
                v.setY(v.getY() + event.getY());
                break;
            case MotionEvent.ACTION_UP:
                get = false;
                break;
        }

        return get;
    }
}
