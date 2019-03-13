package com.serma.crocobisunes.timetable;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends AppCompatActivity {
    ImageButton dir1;
    ImageButton dir2;

    ImageButton drawing;
    ImageButton drinking;
    ImageButton eating;

    TextView question1;

    TextView ansVar1;
    TextView ansVar2;

    public void hideNavigator(){
        View decorView =getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        hideNavigator();

        dir1 = (ImageButton) findViewById(R.id.dir1);

        dir1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Game.this, SecondPage.class);
                startActivity(intent);

            }
        });

        dir2 = (ImageButton) findViewById(R.id.dir2);

        dir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        drawing = (ImageButton) findViewById(R.id.drawing);

        drawing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Game.this, "Неправильно!", Toast.LENGTH_SHORT).show();
                Animation animation = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.translate);
                drawing.startAnimation(animation);

                Animation animation1 = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.scale);
                eating.startAnimation(animation1);
                Toast.makeText(Game.this, "Вот правильный ответ!", Toast.LENGTH_SHORT).show();
            }
        });

        drinking = (ImageButton) findViewById(R.id.drinking);

        drinking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* ansVar1 = (TextView) findViewById(R.id.ansVar1);
                ansVar1.setText("Неправильно!");*/
                Toast.makeText(Game.this, "Неправильно!", Toast.LENGTH_SHORT).show();
                Animation animation = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.translate);
                drinking.startAnimation(animation);

                Animation animation1 = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.scale);
                eating.startAnimation(animation1);
                Toast.makeText(Game.this, "Вот правильный ответ!", Toast.LENGTH_SHORT).show();
            }
        });

        eating = (ImageButton) findViewById(R.id.eating);

        eating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Game.this, "Правильно!", Toast.LENGTH_SHORT).show();
                Animation animation = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.scale);
                eating.startAnimation(animation);

            }
        });
    }
}
