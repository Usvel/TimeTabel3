package com.serma.crocobisunes.timetable;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton btnTimetable=(ImageButton) findViewById(R.id.btnTimetable);
       // ImageButton btnCalendar=(ImageButton) findViewById(R.id.btnCalendar);
        //ImageButton btnCommunicator=(ImageButton) findViewById(R.id.btnCommunicator);
        //ImageButton btnAchievement=(ImageButton) findViewById(R.id.btnAchievement);
       // ImageButton btnHappiness=(ImageButton) findViewById(R.id.btnHappiness);
        btnTimetable.setOnClickListener(MainActivity.this);
    //    btnCalendar.setOnClickListener(MainActivity.this);
    //    btnCommunicator.setOnClickListener(MainActivity.this);
    //    btnAchievement.setOnClickListener(MainActivity.this);
    //    btnHappiness.setOnClickListener(MainActivity.this);
        hideNavigator();


    }
    public void hideNavigator(){
        View decorView =getWindow().getDecorView();
        int uiOptions =View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |  View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    @Override
    public void onClick(View btnImage) {
        switch (btnImage.getId()){
            case R.id.btnTimetable:
                Intent intent =new Intent(MainActivity.this,TimeTable.class);
                startActivity(intent);
                break;
            /*
            case R.id.btnCalendar:
                intent =new Intent(MainActivity.this,Calendar.class);
                startActivity(intent);
                break;
            case R.id.btnCommunicator:
                intent =new Intent(MainActivity.this,Communicator.class);
                startActivity(intent);
                break;
            case R.id.btnAchievement:
                intent =new Intent(MainActivity.this,Achievement.class);
                startActivity(intent);
                break;
            case R.id.btnHappiness:
                intent =new Intent(MainActivity.this,Happiness.class);
                startActivity(intent);
                break;
                */
        }

    }
}
