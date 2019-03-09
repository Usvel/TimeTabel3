package com.serma.crocobisunes.timetable;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.nio.InvalidMarkException;

public class TimeTable extends AppCompatActivity implements View.OnClickListener {


    int [] imgCouch ={R.drawable.facedetection,R.drawable.smile,R.drawable.spa};
    int [] imgTimePn={R.drawable.clock,R.drawable.t1300,R.drawable.t1500};
    int[] imgActionPn ={R.drawable.plateforkandknife,R.drawable.trekking,
            R.drawable.slumber};
    int [] imgTimeVt={R.drawable.clock,R.drawable.clock,R.drawable.clock};
    int[] imgActionVt ={R.drawable.slumber,R.drawable.trekking,
            R.drawable.plateforkandknife};
    String[] dayOfWeek ={"Понедельник","Вторник","Среда","Четверг","Пятница","Суббота","Воскресенье"};
    private int currentDay=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        ListView listView=(ListView) findViewById(R.id.listTimetable);
        CustomAdapter customAdapter =new CustomAdapter();
        listView.setAdapter(customAdapter);
        hideNavigator();

        ImageButton backToMain = (ImageButton) findViewById(R.id.back);
        backToMain.setOnClickListener(TimeTable.this);
        Button myTimetable = (Button) findViewById(R.id.myTimetable);
        myTimetable.setOnClickListener(TimeTable.this);
        ImageButton previousDayOfWeek = (ImageButton) findViewById(R.id.previousDayOfWeek);
        previousDayOfWeek.setOnClickListener(TimeTable.this);
        ImageButton nextDayOfWeek =(ImageButton) findViewById(R.id.nextDayOfWeek);
        nextDayOfWeek.setOnClickListener(TimeTable.this);
        CheckBox complete = findViewById(R.id.complete);

    }
    public void hideNavigator(){
        View decorView =getWindow().getDecorView();
        int uiOptions =View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |  View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    @Override
    public void onClick(View view) {
        ListView listView=(ListView) findViewById(R.id.listTimetable);
        CustomAdapter customAdapter =new CustomAdapter();
        TextView currentDayOfWeek =(TextView) findViewById(R.id.currentDayOfWeek);
        switch (view.getId()){
            case R.id.back:
                Intent intent =new Intent(TimeTable.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.myTimetable:
                intent =new Intent(TimeTable.this,myTimetable.class);
                startActivity(intent);
                break;
            case R.id.previousDayOfWeek:

                if (currentDay==0){
                    currentDay=6;
                    currentDayOfWeek.setText(dayOfWeek[currentDay]);
                    listView.setAdapter(customAdapter);
                }else {
                    currentDay--;
                    currentDayOfWeek.setText(dayOfWeek[currentDay]);
                    listView.setAdapter(customAdapter);
                }
                break;
            case R.id.nextDayOfWeek:

                if (currentDay==6){
                    currentDay=0;
                    currentDayOfWeek.setText(dayOfWeek[currentDay]);
                    listView.setAdapter(customAdapter);
                }else {
                    currentDay++;
                    currentDayOfWeek.setText(dayOfWeek[currentDay]);
                    listView.setAdapter(customAdapter);
                }
                break;
        }


    }

    class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return imgCouch.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.item_list_view,null);
            ImageView time =(ImageView) view.findViewById(R.id.time);
            ImageButton btnAction =(ImageButton) view.findViewById(R.id.action);
            ImageView couch =(ImageView) view.findViewById(R.id.couch);
            if(currentDay==0){
                time.setImageResource(imgTimePn[position]);
                btnAction.setImageResource(imgActionPn[position]);
                couch.setImageResource(imgCouch[position]);

            }else   if(currentDay==1){

                time.setImageResource(imgTimeVt[position]);
                btnAction.setImageResource(imgActionVt[position]);
                couch.setImageResource(imgCouch[position]);

            }

            return view;
        }
    }

}
