package com.example.practica1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int accion=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GraficoView grafico= new GraficoView(this);
        setContentView(grafico);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.operaciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.itlineas:
                Intent intent=new Intent(MainActivity.this,Acitividad.class);
                startActivity(intent);
                break;
            case R.id.itOndas:
                Intent intent1= new Intent(MainActivity.this,Ondas.class);
                startActivity(intent1);
                break;
            case R.id.itTranslado:
                Intent intent2= new Intent(MainActivity.this,Traslado.class);
                startActivity(intent2);
                break;
            case R.id.itPuntero:
                Intent intent3= new Intent(MainActivity.this,Puntero.class);
                startActivity(intent3);
                break;
            case  R.id.itAnimacion:
                Intent intent4= new Intent(MainActivity.this,Animacion.class);
                startActivity(intent4);
                break;
        }
        return true;
    }

    private class GraficoView extends View
    {

        public GraficoView(Context context) {
            super(context);
        }


        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

                Paint paint = new Paint();
                paint.setColor(Color.WHITE);
                canvas.drawPaint(paint);
                int width= canvas.getWidth();
                int height= canvas.getHeight();
                paint.setColor(Color.BLACK);
                paint.setTextSize(30);
                paint.setAntiAlias(true);
                canvas.drawText("Ancho"+width+", alto "+height,20,40,paint);
                paint.setColor(Color.rgb(100,20,20));
                canvas.drawLine(0,40,width,40,paint);
                paint.setColor(Color.rgb(0,100,200));
                canvas.drawLine(20,0,20,height,paint);
                //Letras
                paint.setColor(Color.rgb(0,100,20));
                canvas.drawLine(width/2,0,width/2,height,paint);
                paint.setColor(Color.BLACK);
                paint.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText("Aling.Right",width/2,160,paint);
                paint.setTextAlign(Paint.Align.CENTER);
                canvas.drawText("Aling.Center",width/2,120,paint);
                paint.setTextAlign(Paint.Align.LEFT);
                canvas.drawText("Aling.Left",width/2,80,paint);

                paint.setTextScaleX(2f);
                canvas.drawText("TextScaleX 2",10,250,paint);
                paint.setTextScaleX(-2f);
                canvas.drawText("TextScaleX -2",20,290,paint);
                paint.setTextSize(60);
                paint.setTextScaleX(0.5f);
                canvas.drawText("TextScaleX 0.5",width/2,360,paint);
                paint.setTextScaleX(1f);
                paint.setTextSize(30);

                paint.setTypeface(Typeface.SANS_SERIF);
                canvas.drawText("Sans Serief",20,330,paint);
                paint.setTypeface(Typeface.DEFAULT_BOLD);
                canvas.drawText("Default Bold",20,370,paint);
                paint.setTypeface(Typeface.MONOSPACE);
                canvas.drawText("Monospace",20,410,paint);
                paint.setTypeface(Typeface.SERIF);
                canvas.drawText("Serif",20,450,paint);
                paint.setTypeface(Typeface.DEFAULT);

                    paint.setTextSize(50);
                    paint.setAntiAlias(false);
                    canvas.drawText("Antialias False",20,500,paint);
                    paint.setAntiAlias(true);
                    canvas.drawText("Antialias True",20,550,paint);



        }
    }



}