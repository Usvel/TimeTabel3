package com.serma.crocobisunes.timetable;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class ChoosenTimetable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosen_timetable);

hideNavigator();
        Intent intent = getIntent();
        if (intent.getStringExtra("shower")!=null) {
            TextView textShower = (TextView) findViewById(R.id.textShower);
            textShower.setText("Принять душ");
        }
        else if (intent.getStringExtra("food")!=null) {
            TextView textFood = (TextView) findViewById(R.id.textFood);
            textFood.setText("Поесть");
        }
        else if(intent.getStringExtra("walk")!=null){
            TextView textWalk = (TextView) findViewById(R.id.textWalk);
            textWalk.setText("Погулять");
        }
        else  if(intent.getStringExtra("talk")!=null){
            TextView textTalk = (TextView) findViewById(R.id.textTalk);
            textTalk.setText("Общение");
        }

    }
    public void hideNavigator(){
        View decorView =getWindow().getDecorView();
        int uiOptions =View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |  View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
}
