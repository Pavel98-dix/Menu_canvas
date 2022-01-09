package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class Puntero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntero);
        SpecialView myView= new SpecialView(this);
        setContentView(myView);
    }
    class SpecialView extends View
    {
        float x=50;
        float y=50;
        String texto="";

        public SpecialView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawColor(Color.LTGRAY);
            Paint paint= new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            canvas.drawCircle(x,y,20,paint);
            paint.setColor(Color.BLACK);
            canvas.drawText("x= "+x,100,50,paint);
            canvas.drawText("y= "+y,100,90,paint);
            canvas.drawText("Texto= "+texto,100,130,paint);
        }

        public boolean onTouchEvent(MotionEvent event)
        {
            x=event.getX();
            y=event.getY();

            if (event.getAction()==MotionEvent.ACTION_DOWN){
                texto="Action Down";
            }
            if (event.getAction()==MotionEvent.ACTION_UP)
            {
                texto="Action Up";
            }
            if (event.getAction()==MotionEvent.ACTION_MOVE){
                texto="action move";
                invalidate();
            }
            return true;
        }
    }
}