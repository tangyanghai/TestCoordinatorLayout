package com.tyh.java.myapplication.nestedScroll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tyh.java.myapplication.R;
import com.tyh.java.myapplication.widget.ResizableImageView;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/7
 * 描述:
 */
public class SimpleNestedScrollActivity extends AppCompatActivity {

    LinearLayout ll;
    NestedScrollView ns;
    NestedScrollView ns2;
    TextView bar;
    ResizableImageView imgV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_nested_scroll);
        ns = findViewById(R.id.ns);
        ns2 = findViewById(R.id.ns_2);
        bar = findViewById(R.id.bar);
        imgV = findViewById(R.id.img);
        ll = findViewById(R.id.ll);
        ll.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ViewGroup.LayoutParams p = ll.getLayoutParams();
                p.height = ns.getMeasuredHeight()+imgV.getMeasuredHeight();
                ll.setLayoutParams(p);
            }
        });
        ns2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ViewGroup.LayoutParams p2 = ns2.getLayoutParams();
                p2.height = ns.getMeasuredHeight() - bar.getMeasuredHeight();
                ns2.setLayoutParams(p2);
            }
        });
    }

}
