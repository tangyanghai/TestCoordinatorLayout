package com.tyh.java.myapplication.coordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.tyh.java.myapplication.R;

/**
 * 创建人: tyh
 * 创建时间: 2019/2/27
 * 描述:顶部滑动--标题透明--图片缩放
 */
public class TopMoveWithTitleAlphaWithImgScaleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_img);
    }


}
