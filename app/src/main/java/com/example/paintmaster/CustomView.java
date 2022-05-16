package com.example.paintmaster;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

/*
*뷰에 그래픽 그리기
 -1. 새로운 클래스를 만든 후 뷰를 상속함
 -2. Paint 객체를 초기화하고 필요한 속성을 설정함
 -3. onDraw() 내에 그리는 메서드를 호출함
 -4. onTouchEvent() 내에 터치 이벤트를 처리하는 코드를 넣음
 -5. 새로 만든 뷰를 MainActivity에 추가함
 */

public class CustomView extends View { // 1. View 상속

    private Paint paint;

    public CustomView(Context context) {
        super(context);

        init(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        paint = new Paint(); // 2. Paint 객체 초기화
        paint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) { // 3. onDraw() 구현
        super.onDraw(canvas);

        canvas.drawRect(100, 100, 200, 200, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) { // 4. onTouchEvent() 구현
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            Toast.makeText(super.getContext(), "MotionEvent.ACTION_DOWN : " + event.getX() + ", " + event.getY(), Toast.LENGTH_SHORT).show();
        }
        return super.onTouchEvent(event);
    }
}