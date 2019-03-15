package com.tyh.java.myapplication.nestedScroll;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tyh.java.myapplication.R;
import com.tyh.java.myapplication.coordinatorLayout.LearnCoordinatorLayoutActivity;
import com.tyh.java.myapplication.coordinatorLayout.TopMoveWithTitleAlphaWithImgScaleActivity;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/7
 * 描述:
 */
public class NestedScrollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_scroll);
    }

    public void onViewClicked(View v) {
        Class cls = null;
        switch (v.getId()) {
            case R.id.bt_simple_nested_scroll://
                cls = SimpleNestedScrollActivity.class;
                break;
        }

        if (cls != null) {
            ActivityCompat.startActivity(this, new Intent(this, cls), null);
        }
    }
}
