package com.example.paintmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.event_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.pen1: // 얇은 펜
                singleTouchView.paint.setStrokeWidth(4f);
                break;

            case R.id.pen2: // 중간 펜
                singleTouchView.paint.setStrokeWidth(10f);
                break;

            case R.id.pen3: // 굵은 펜
                singleTouchView.paint.setStrokeWidth(22f);
                break;

            case R.id.showIntent: // 테스트 화면으로 전환하기 메뉴
                Intent intent = new Intent(getApplicationContext(), PaintTestActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}