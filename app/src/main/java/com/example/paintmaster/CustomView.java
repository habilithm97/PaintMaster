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

*그래픽을 그릴 때 필요한 클래스와 메서드
 -Canvas : 뷰의 표면에 직접 그릴 수 있도록 만들어 주는 객체, 그래픽 그리기를 위한 메서드가 정의되어 있음(도화지)
 -Paint : 그래픽 그리기를 위해 필요한 속성을 담고 있음(붓)
 -Bitmap : 픽셀로 구성된 이미지로 메모리에 그래픽을 그릴 수 있음
 -Drawable : 그래픽 요소가 객체로 정의되어 있음

-Clipping : 그리기 연산이 일어나는 영역을 설정하는 것으로써 clipRect() 또는 clipRegion()을 이용하면 클리핑 영역 설정 가능함
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
