package com.example.adityad.dummyapplication2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DrawFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by adityad on 7/27/17.
 */

public class MaskView2 extends View {

    private Paint mHolePaint;
    private Paint mDarkPaint;

    public MaskView2(Context context) {
        this(context, null);
    }

    public MaskView2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MaskView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        mHolePaint = new Paint();
        mHolePaint.setColor(Color.BLACK);
        mHolePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));

        mDarkPaint = new Paint();
        mDarkPaint.setARGB(150, 0 , 0, 0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float centerX = canvas.getWidth()/2;
        float centerY = canvas.getHeight()/2;
//        canvas.drawRect(centerX-100, centerY-100, centerX+100, centerY+100, mDarkPaint);
        canvas.drawPaint(mDarkPaint);
        canvas.drawCircle(centerX, centerY, 50, mHolePaint);
    }
}
