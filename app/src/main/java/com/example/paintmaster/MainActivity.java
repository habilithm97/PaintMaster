package com.example.paintmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    SingleTouchView singleTouchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singleTouchView = (SingleTouchView)findViewById(R.id.singleTouchView);

        LinearLayout paintLayout = (LinearLayout)findViewById(R.id.paintColor);
        LinearLayout paintLayout2 = (LinearLayout)findViewById(R.id.paintColor2);
    }
}