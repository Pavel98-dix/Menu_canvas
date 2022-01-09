package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

public class Ondas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ondas);
        SpecialView myView= new SpecialView(this);
        setContentView(myView);
    }

    private class SpecialView extends View {

        public SpecialView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            int width= canvas.getWidth();
            int height= canvas.getHeight();
            canvas.drawColor(Color.WHITE);
            Paint paint= new Paint();
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(2);
            paint.setAntiAlias(true);

            Path path= new Path();
            path.moveTo(0,0);
            for (int i=1;i<width;i++)
            {
                path.lineTo(i,(float)Math.sin(i/20f)*(-50f));
            }
            path.offset(0,100);
            canvas.drawPath(path,paint);

            float[] intervalos={10,10};
            DashPathEffect dash= new DashPathEffect(intervalos,1);
            paint.setPathEffect(dash);
            path.offset(0,100);
            canvas.drawPath(path,paint);

            float[] intervalos2={10,10,2,10};
            DashPathEffect dash2= new DashPathEffect(intervalos2,0);
            paint.setPathEffect(dash2);
            path.offset(0,100);
            canvas.drawPath(path,paint);

            float[] intervalo3={2,4};
            DashPathEffect dash3= new DashPathEffect(intervalo3,1);
            paint.setPathEffect(dash3);
            path.offset(0,100);
            canvas.drawPath(path,paint);



        }
    }
}