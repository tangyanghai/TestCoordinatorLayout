package com.tyh.java.myapplication.coordinatorLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.tyh.java.myapplication.R;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/4
 * 描述:
 */
public class JdyOrderWithCanadaActivity extends AppCompatActivity {
    AppBarLayout mAppBar;
    NestedScrollView scSolid;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_can_move_part);
        mAppBar = findViewById(R.id.app_bar);
        RefreshLayout refreshLayout = (RefreshLayout) findViewById(R.id.sr);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setEnableLoadMore(false);
        scSolid = findViewById(R.id.sc_solid);
    }

    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.tv_solid:
                ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                if (v.getTag() == null) {
                    v.setTag(layoutParams.height);
                    layoutParams.height = 500;
                } else {
                    layoutParams.height = (int) v.getTag();
                    v.setTag(null);
                }
                v.setLayoutParams(layoutParams);
                /*ViewGroup.LayoutParams p = scSolid.getLayoutParams();
                p.height = layoutParams.height;
                scSolid.setLayoutParams(p);
                scSolid.postInvalidate();*/
                break;
        }
    }
}
