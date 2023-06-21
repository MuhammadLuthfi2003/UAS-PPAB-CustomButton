package com.example.customview_uas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomButton extends View {

    private int x1, y1, x2, y2;
    private Paint textPaint, buttonPaint;
    private boolean isOriginalColor = false;

    private void init() {
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.BLACK);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(40f);

        buttonPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        buttonPaint.setColor(Color.GREEN);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isOriginalColor) {
                    buttonPaint.setColor(Color.RED);
                    isOriginalColor = false;
                }
                else {
                    buttonPaint.setColor(Color.GREEN);
                    isOriginalColor = true;
                }

                invalidate();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        x1 = getWidth()/2 - 200;
        x2 = getWidth()/2 + 200;
        y1 = getHeight()/2 - 100;
        y2 = getHeight()/2 + 100;

        canvas.drawRect(x1, y1, x2, y2, buttonPaint);
        canvas.drawText("CLICK ME",x1 + 175, y1 +125, textPaint);
    }

    public CustomButton(Context context) {
        super(context);
        init();
    }

    public CustomButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
}
