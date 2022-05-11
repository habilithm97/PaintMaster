package com.example.paintmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    SingleTouchView singleTouchView;

    Button curPaint, curPaint2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singleTouchView = (SingleTouchView)findViewById(R.id.singleTouchView);

        LinearLayout paintLayout = (LinearLayout)findViewById(R.id.paintColor);
        LinearLayout paintLayout2 = (LinearLayout)findViewById(R.id.paintColor2);

        // paintLayout에 담긴 버튼들을 순회하며 동작 가능하게함
        curPaint = (Button)paintLayout.getChildAt(0);
        curPaint2 = (Button)paintLayout2.getChildAt(0);

        Button newBtn = (Button)findViewById(R.id.newBtn);
        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleTouchView.setNew();
            }
        });

        Button saveBtn = (Button)findViewById(R.id.saveBtn);
    }

    public void colorClick(View view) {
        if(view != curPaint) {
            String color = view.getTag().toString(); // 버튼 Tag의 색상 값을 가져와서
            singleTouchView.setColor(color); // 색상 값을 View를 상속한 클래스의 setColor()에 파라미터로 담아서 호출함
            curPaint = (Button)view;
        }
    }

    public void colorClick2(View view) {
        if (view != curPaint2) {
            String color2 = view.getTag().toString();
            singleTouchView.setColor(color2);
            curPaint2 = (Button) view;
        }
    }
}