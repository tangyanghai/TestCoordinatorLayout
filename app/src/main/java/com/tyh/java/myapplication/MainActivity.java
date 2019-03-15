package com.tyh.java.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tyh.java.myapplication.coordinatorLayout.LearnCoordinatorLayoutActivity;
import com.tyh.java.myapplication.coordinatorLayout.TopMoveWithTitleAlphaWithImgScaleActivity;
import com.tyh.java.myapplication.nestedScroll.NestedScrollActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onViewClicked(View v) {
        Class cls = null;
        switch (v.getId()) {
            case R.id.bt_learn_coordinator_layout://
                cls = LearnCoordinatorLayoutActivity.class;
                break;
            case R.id.bt_nested_scroll://
                cls = NestedScrollActivity.class;
                break;
        }

        if (cls != null) {
            ActivityCompat.startActivity(this, new Intent(this, cls), null);
        }
    }
}
