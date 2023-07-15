package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView circle,arrow;
    Button start,stop,reset;

    Animation alpha,alpha2;
    Chronometer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circle=findViewById(R.id.circle);
        arrow=findViewById(R.id.arrow);

        timer=findViewById(R.id.simpleChronometer);

        start=findViewById(R.id.start);
        stop=findViewById(R.id.stop);
        reset=findViewById(R.id.reset);

        reset.setVisibility(View.INVISIBLE);
        alpha= AnimationUtils.loadAnimation(this,R.anim.alpha);
        alpha2= AnimationUtils.loadAnimation(this,R.anim.alpha2);

        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                arrow.startAnimation(alpha);
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
            }
        }
        );

        stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                timer.stop();
                reset.setVisibility(View.VISIBLE);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                arrow.startAnimation(alpha2);
                timer.setBase(SystemClock.elapsedRealtime());
                reset.setVisibility(View.INVISIBLE);
            }
        });


    }

}