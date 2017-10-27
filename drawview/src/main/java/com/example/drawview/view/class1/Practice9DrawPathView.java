package com.example.drawview.view.class1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    Path path=new Path();
    Paint paint=new Paint();
    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        path.addArc(200,200,400,400,-225,225);
        path.arcTo(400,200, 600,400,-180,225,false);
        path.lineTo(400,542);
//        练习内容：使用 canvas.drawPath() 方法画心形
        canvas.drawPath(path,paint);
    }
}
