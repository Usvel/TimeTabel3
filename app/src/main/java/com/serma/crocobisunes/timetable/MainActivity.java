package com.serma.crocobisunes.timetable;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private NavigationView nav_view;
    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideNavigator();


        setContentView(R.layout.activity_main);
        ImageButton btnTimetable=(ImageButton) findViewById(R.id.btnTimetable);
        ImageButton btnGame=(ImageButton) findViewById(R.id.btnGame);
        ImageButton btnMenu=(ImageButton) findViewById(R.id.btnMenu);
       // ImageButton btnCalendar=(ImageButton) findViewById(R.id.btnCalendar);
        //ImageButton btnCommunicator=(ImageButton) findViewById(R.id.btnCommunicator);
        //ImageButton btnAchievement=(ImageButton) findViewById(R.id.btnAchievement);
       // ImageButton btnHappiness=(ImageButton) findViewById(R.id.btnHappiness);
//        btnTimetable.setOnClickListener(MainActivity.this);
        //btnGame.setOnClickListener(MainActivity.this);
        //btnMenu.setOnClickListener(MainActivity.this);
    //    btnCalendar.setOnClickListener(MainActivity.this);
    //    btnCommunicator.setOnClickListener(MainActivity.this);
    //    btnAchievement.setOnClickListener(MainActivity.this);
    //    btnHappiness.setOnClickListener(MainActivity.this);
        hideNavigator();

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(this);

        ImageButton btnFood=(ImageButton) findViewById(R.id.btnFood12);
        btnFood.setOnClickListener(this);
//        ImageButton btnFood=(ImageButton) findViewById(R.id.bt);
        btnFood.setOnClickListener(this);


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

            case R.id.btnMenu:
                intent =new Intent(MainActivity.this, Menu.class);
                startActivity(intent);
                break;

            case R.id.btnGame:
                intent =new Intent(MainActivity.this,Game.class);
                startActivity(intent);
                break;

            case R.id.btnFood12:
//                Log.e("Message","Text");
                Log.i("Message","Text");
                mDrawer.closeDrawers();
                break;

//            case R.id.btnAchievement:
//                intent =new Intent(MainActivity.this,Achievement.class);
//                startActivity(intent);
//                break;
//            case R.id.btnHappiness:
//                intent =new Intent(MainActivity.this,Happiness.class);
//                startActivity(intent);
//                break;

        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // set item as selected to persist highlight
        menuItem.setChecked(true);
        // close drawer when item is tapped
        mDrawer.closeDrawers();
        Log.i("MSG","WORK");
        // Add code here to update the UI based on the item selected
        // For example, swap UI fragments here
        return false;
    }



}
