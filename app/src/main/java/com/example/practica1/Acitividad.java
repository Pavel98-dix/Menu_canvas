package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class Acitividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitividad);
        SpecialView myView= new SpecialView(this);
        setContentView(myView);
    }
    private class SpecialView extends View
    {

        public SpecialView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            int width= canvas.getWidth();
            int height= canvas.getHeight();
            int bottom=getBottom();
            int right=getRight();
            canvas.drawColor(Color.WHITE);

            Paint paintBlack= new Paint();
            Paint paintGray= new Paint();
            paintBlack.setColor(Color.BLACK);
            paintGray.setColor(Color.GRAY);

            for (int i=30; i<height;i+=30)
            {
                canvas.drawLine(0,i,width,i,paintGray);
                canvas.drawText(" "+i,30,i,paintBlack);

            }

            paintBlack.setTextSize(30);
            paintBlack.setAntiAlias(true);
            canvas.drawText("height= "+height,100,height/2,paintBlack);

            paintBlack.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("Width" + width,width/2,40,paintBlack);
            canvas.drawText("Height"+height + width,width/2,80,paintBlack);
            canvas.drawText("Right" + right,width/2,120,paintBlack);
            canvas.drawText("Bottom" + bottom,width/2,160,paintBlack);

            paintBlack.setColor(Color.BLUE);
            canvas.drawLine(0,0,right,bottom,paintBlack);
            canvas.drawLine(right,0,0,bottom,paintBlack);



        }
    }

}

