package com.example.paintmaster;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;

/*
*Drawable 객체로 만들어서 그리기
 -그래픽 그리기가 가능한 요소들은 Drawable 객체 생성 후 그릴 수 있음
 -그리기 객체로 만들어서 그리는 이유 : 그래픽을 그리는 하나의 단위를 그리기 객체로 만들어 두면
   각각의 그래픽 그리기 작업을 독립적인 객체로 나누어 관리할 수 있고, 이 객체에 애니메이션을 적용할 수도 있음

 -그리기 객체를 사용하는 방법
  -1. 리소스 파일의 사용 : 리소스 폴더에 이미지 파일을 포함시킨 후 읽어 들여서 사용함
  -2. XML 파일로 정의하여 사용 : 그리기 객체의 속성을 정의한 XML 파일을 정의하여 사용함
  -3. 소스 코드에서 객체를 만들어서 사용 : new를 이용하여 그리기 객체 생성 후 사용함, 비트맵 이미지를 좌표 값에 그림
*/

public class CustomViewDrawable extends View {

    ShapeDrawable upperDrawable;
    ShapeDrawable lowerDrawable;

    public CustomViewDrawable(Context context) {
        super(context);

        init(context);
    }

    public CustomViewDrawable(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        // 윈도우 매니저를 이용해 View가 채워지는 화면의 크기(폭과 높이)를 확인
        WindowManager manager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();

        // 리소스에 정의된 색상 값을 변수에 할당
        Resources resources = getResources();
        int color1 = resources.getColor(R.color.purple_200);
        int color2 = resources.getColor(R.color.purple_500);
        int color3 = resources.getColor(R.color.purple_700);

        upperDrawable = new ShapeDrawable(); // 위 쪽의 Drawable 객체 생성

        RectShape rectangle = new RectShape();
        rectangle.resize(width, height*2/3);
        upperDrawable.setShape(rectangle);
        upperDrawable.setBounds(0, 0, width, height*2/3);

        // LinearGradient 객체 생성
        //  -> View 영역의 위쪽 2/3와 아래쪽 1/3을 따로 채워줌으로써 위쪽에서부터 아래쪽으로 색상이 조금씩 변하는 배경화면을 만들 수 있음
        // 선형 그라데이션을 구현하는데 하나의 직선 그라데이션 축을 따라 서로 혼합되는 여러 가지 색으로 영역을 그릴 수 있음
        LinearGradient gradient = new LinearGradient(0, 0, 0, height*2/3, color2, color1, Shader.TileMode.CLAMP);

        Paint paint = upperDrawable.getPaint();
        paint.setShader(gradient); // Paint 객체에 새로 생성한 LinearGradient 객체를 Shader로 설정

        lowerDrawable = new ShapeDrawable(); // 아래 쪽의 Drawable 객체 생성

        RectShape rectangle2 = new RectShape();
        rectangle2.resize(width, height*1/3);
        lowerDrawable.setShape(rectangle2);
        lowerDrawable.setBounds(0, height*1/3, width, height);

        LinearGradient gradient2 = new LinearGradient(0, 0, 0, height*1/3, color1, color3, Shader.TileMode.CLAMP);

        Paint paint2 = lowerDrawable.getPaint();
        paint2.setShader(gradient2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Drawable 객체 그리기
        upperDrawable.draw(canvas);
        lowerDrawable.draw(canvas);
    }
}
