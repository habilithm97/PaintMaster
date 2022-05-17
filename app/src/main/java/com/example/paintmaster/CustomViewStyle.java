package com.example.paintmaster;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomViewStyle extends View {

    Paint paint;

    public CustomViewStyle(Context context) {
        super(context);

        init(context);
    }

    public CustomViewStyle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 첫 번째 사각형
        paint.setStyle(Paint.Style.FILL); // 테두리는 그리지 않고 색상만 채움
        paint.setColor(Color.RED);
        canvas.drawRect(10, 10, 100, 100, paint);

        // 첫 번째 사각형
        paint.setStyle(Paint.Style.STROKE); // 색상 채우기 없이 테두리만 그림
        paint.setStrokeWidth(2.0F); // 선의 두께
        paint.setColor(Color.GREEN);
        canvas.drawRect(10, 10, 100, 100, paint);

        // 두 번째 사각형
        paint.setStyle(Paint.Style.FILL); // 테두리는 그리지 않고 색상만 채움
        paint.setARGB(128, 0, 0, 255); // a는 투명도
        canvas.drawRect(120, 10, 210, 100, paint);

        // 두 번째 사각형
        // float 배열은 점선의 크기를 정하는 값으로 첫 번째 값은 점선의 길이값이고 두 번째 값은 점선 사이의 간격값임
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{5, 5}, 1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setPathEffect(dashPathEffect);
        paint.setColor(Color.BLUE);
        canvas.drawRect(120, 10, 210, 100, paint);

        paint = new Paint();

        // 첫 번째 원
        paint.setColor(Color.MAGENTA);
        canvas.drawCircle(50, 160, 40, paint);

        // 두 번째 원
        paint.setAntiAlias(true); // 부드러운 선
        canvas.drawCircle(160, 160, 40, paint);

        // 첫 번째 텍스트
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1); // 선의 두께
        paint.setColor(Color.MAGENTA);
        paint.setTextSize(30);
        canvas.drawText("Text (Stroke)", 20, 260, paint);

        // 두 번째 텍스트
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(30);
        canvas.drawText("Test", 20, 320, paint);
    }
}
