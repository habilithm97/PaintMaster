package com.example.paintmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PaintTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_test);

        //CustomView view = new CustomView(this); // 5. MainActivity에 CustomView 클래스 추가
        CustomViewStyle view = new CustomViewStyle(this);
        setContentView(view);
    }
}