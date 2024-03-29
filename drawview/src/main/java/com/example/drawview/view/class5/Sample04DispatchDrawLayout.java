package com.example.drawview.view.class5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.drawview.R;

/**
 * Created by 否命题 on 2017/10/31.
 */

public class Sample04DispatchDrawLayout extends LinearLayout{
    Pattern pattern = new Pattern();

    public Sample04DispatchDrawLayout(Context context) {
        super(context);

        setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.batman);
        imageView.setImageBitmap(bitmap);
        addView(imageView);
    }

    public Sample04DispatchDrawLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample04DispatchDrawLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);

        pattern.draw(canvas);
    }
    private class Pattern {
        private static final float PATTERN_RATIO = 5f / 6;

        Paint patternPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Spot[] spots;

        private Pattern() {
            spots = new Spot[4];
            spots[0] = new Spot(0.14f, 0.3f, 0.026f);
            spots[1] = new Spot(0.59f, 0.25f, 0.067f);
            spots[2] = new Spot(0.22f, 0.6f, 0.067f);
            spots[3] = new Spot(0.52f, 0.78f, 0.083f);
        }

        private Pattern(Spot[] spots) {
            this.spots = spots;
        }

        {
            patternPaint.setColor(Color.parseColor("#A0E91E63"));
        }

        private void draw(Canvas canvas) {
            int repitition = (int) Math.ceil((float) getWidth() / getHeight());
            for (int i = 0; i < spots.length * repitition; i++) {
                Spot spot = spots[i % spots.length];
                canvas.drawCircle(i / spots.length * getHeight() * PATTERN_RATIO + spot.relativeX * getHeight(), spot.relativeY * getHeight(), spot.relativeSize * getHeight(), patternPaint);
            }
        }

        private class Spot {
            private float relativeX;
            private float relativeY;
            private float relativeSize;

            private Spot(float relativeX, float relativeY, float relativeSize) {
                this.relativeX = relativeX;
                this.relativeY = relativeY;
                this.relativeSize = relativeSize;
            }
        }
    }
}
