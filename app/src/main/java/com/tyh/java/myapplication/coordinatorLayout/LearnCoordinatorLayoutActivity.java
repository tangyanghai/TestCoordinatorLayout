package com.tyh.java.myapplication.coordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tyh.java.myapplication.R;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/7
 * 描述:
 */
public class LearnCoordinatorLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_coordinator_layout);
    }

    public void onViewClicked(View v) {
        Class cls = null;
        switch (v.getId()) {
            case R.id.bt_moving_button://跟随移动的view
                cls = FollowMovingActivity.class;
                break;
            case R.id.bt_top_img://头部滑动+标题透明+图片缩放
                cls = TopMoveWithTitleAlphaWithImgScaleActivity.class;
                break;
            case R.id.bt_top_can_move_part_view://接单易--订单--滑动预研
                cls = JdyOrderWithCanadaActivity.class;
                break;
            case R.id.bt_move_in_out://顶部滑入划出
                cls = TopMoveWithInAndOutKits.class;
                break;
        }

        if (cls != null) {
            ActivityCompat.startActivity(this, new Intent(this, cls), null);
        }
    }
}
