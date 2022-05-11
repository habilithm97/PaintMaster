package com.example.paintmaster;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class SingleTouchView extends View {

    Paint paint = new Paint(); // Paint 객체로 그림을 그림(붓)
    Path path = new Path(); // Canvas를 이용하여 그림을 그릴 때 사용함
    int paintColor = 0xff000000;

    Bitmap bitmap;
    Canvas canvas; // View 위에 그림을 그릴 수 있는 도화지
    Paint canvasPaint;

    public SingleTouchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint.setAntiAlias(true); // Paint의 경계면을 부드럽게 처리할지 설정
        paint.setStrokeWidth(10f); // Paint의 굵기를 설정
        paint.setColor(paintColor);
        paint.setStyle(Paint.Style.STROKE);
        // MITER(모서리를 90도 각진 형태, 디폴트), BEVEL(모서리가 깎인 형태), ROUND(둥근 형태)
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override // 화면의 사이즈가 변하거나 초기 액티비티가 생성될 때 호출됨
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);

        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    @Override // View가 다시 그려져야 할 때 호출됨
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap, 0, 0, canvasPaint);
        canvas.drawPath(path, paint); // Path를 화면에 그림
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(touchX, touchY); // 시작 좌표
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(touchX, touchY); // 끝나는 좌표
                break;
                case MotionEvent.ACTION_UP:
                    canvas.drawPath(path, paint); // Path를 화면에 그림
                    path.reset(); // Path 초기화
                    break;
            default:
                return false;
        }
        invalidate();
        return true;
    }

    public void setColor(String newColor) {
        invalidate();
        paintColor = Color.parseColor(newColor);
        paint.setColor(paintColor);
    }

    public void setNew() { // MainActivity의 newBtn(새 그림 버튼) 클릭 시 비트앱을 지움(완전 초기화 불가능, 투명색으로 덮씌우기)
        bitmap.eraseColor(Color.TRANSPARENT);
        invalidate();
    }
}
