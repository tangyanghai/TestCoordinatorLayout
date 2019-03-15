package com.tyh.java.myapplication.coordinatorLayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tyh.java.myapplication.R;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/5
 * 描述:顶部滑入滑出组件
 */
public class TopMoveWithInAndOutKits extends AppCompatActivity {

    CoordinatorLayout v;

    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_move_in_and_out_kits);
        v = findViewById(R.id.v_content);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                return new RecyclerView.ViewHolder(LayoutInflater.from(TopMoveWithInAndOutKits.this).inflate(R.layout.item_tv_full_screen, viewGroup, false)) {
                    @Override
                    public String toString() {
                        return super.toString();
                    }
                };
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            }

            @Override
            public int getItemCount() {
                return 1;
            }
        });
    }

    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.tv_top_in://
                Toast.makeText(this, "从AppBarLayout顶部滑入的View", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_bottom_in://
                Toast.makeText(this, "从AppBarLayout底部滑入的View", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        return super.dispatchTouchEvent(ev);
    }
}
