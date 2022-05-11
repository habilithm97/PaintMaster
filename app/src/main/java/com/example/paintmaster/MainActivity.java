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

        curPaint = (Button)paintLayout.getChildAt(0);
        curPaint2 = (Button)paintLayout2.getChildAt(0);

        Button newBtn = (Button)findViewById(R.id.newBtn);
        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleTouchView.setNew();
            }
        });
    }
}