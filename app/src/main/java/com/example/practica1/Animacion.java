package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Animacion extends AppCompatActivity {
    Button b1,b2,b3,b4,b5;
    ImageView v1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animacion);

        b1=(Button) findViewById(R.id.b1);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        b4=(Button) findViewById(R.id.button4);
        b5=(Button) findViewById(R.id.btapa);
        v1=(ImageView) findViewById(R.id.img1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trans();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transInversa();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotacionImagen();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dilatacion();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aparicion();
            }
        });
    }

    private void dilatacion()
    {
        Animation animation4= AnimationUtils.loadAnimation(this,R.anim.dilatacion);
        animation4.setFillAfter(true);
        v1.startAnimation(animation4);
    }

    private void rotacionImagen()
    {
        Animation animation3= AnimationUtils.loadAnimation(this,R.anim.rotacion);
        v1.startAnimation(animation3);
        b1.startAnimation(animation3);
    }

    private void aparicion()
    {
        Animation animation5= AnimationUtils.loadAnimation(this,R.anim.aparicion);
        animation5.setFillAfter(true);
        v1.startAnimation(animation5);
    }


    private void trans()
    {
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.trans);
        animation.setFillAfter(false);
        v1.startAnimation(animation);
    }

    private void transInversa()
    {
        Animation animation2= AnimationUtils.loadAnimation(this,R.anim.trans2);
        animation2.setFillAfter(true);
        v1.startAnimation(animation2);
    }
}