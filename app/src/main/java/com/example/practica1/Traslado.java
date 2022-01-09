package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

public class Traslado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traslado);
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
            canvas.drawColor(Color.WHITE);
            Paint paint= new Paint();
            Path path= new Path();

            //Se traslado el origen de canvas
            int x=50;
            int y=60;
            canvas.translate(x,y);

            //Rectangulo bounding-box de texto

            String texto="Rotacion de canvas";
            Rect rectangulo=new Rect();
            paint.getTextBounds(texto,0,texto.length(),rectangulo);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(rectangulo,paint);
            canvas.save();

            //Centro del rectangulo
            float centerX=rectangulo.exactCenterX();
            float centerY=rectangulo.exactCenterY();

            canvas.rotate(-45,centerX,centerY);
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawText(texto,0,0,paint);

            //Restablecer Canvas
            canvas.restore();
            canvas.drawText("Tras la rotacion restante",100,300,paint);


            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.STROKE);
            Path.Direction dir=Path.Direction.CCW;
            float radio=150;
            path.addCircle(width/2,500,radio,dir);
            path.offset(0,0);
            float hOffset=0;
            float vOffset=20;
            canvas.drawPath(path,paint);
            paint.setColor(Color.BLACK);
            canvas.drawTextOnPath("Texto en la parte exterior punto incial"+hOffset,path,hOffset,vOffset,paint);

            hOffset=200;
            vOffset=100;

            paint.setStyle(Paint.Style.FILL);
            paint.setTextSize(40);
            canvas.drawTextOnPath("Texto interior comenzando a "+hOffset+" del punto inicial",path,hOffset,vOffset,paint);

        }

    }

}