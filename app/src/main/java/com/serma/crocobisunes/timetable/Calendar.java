package com.serma.crocobisunes.timetable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Date;

public class Calendar extends AppCompatActivity {
    ListView listView;
    int [] imgHolyday4={R.drawable.valentin,R.drawable.feb23};
    String [] name4={"День всех влюблённых","День защитника отечества"};
    int [] imgHolyday5={R.drawable.smile};
    String [] name5={"Другие праздники"};
    int currentMonth=4;
    int currentLength=0;
    CalendarView calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        hideNavigator();
        listView =(ListView) findViewById(R.id.holyday);
        final CustomAdapter customAdapter =new CustomAdapter();
        listView.setAdapter(customAdapter);
        calendar=(CalendarView) findViewById(R.id.calendarView);
        calendar.setDate(1549238400);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view,
                                            int year, int month, int dayOfMonth) {
                if(month==1){
                    currentMonth=1;
                    currentLength=imgHolyday4.length;
                    listView.setAdapter(customAdapter);

                }else   if(month==2){
                    currentMonth=2;
                    currentLength=imgHolyday5.length;
                    listView.setAdapter(customAdapter);

                }
            }
        });
    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return currentLength;
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

            View view = getLayoutInflater().inflate(R.layout.item_holyday,null);
            ImageView imgHolyday =(ImageView) view.findViewById(R.id.imgHolyday);
            TextView name =(TextView) view.findViewById(R.id.name);
            if(currentMonth==1){
                imgHolyday.setImageResource(imgHolyday4[position]);
                name.setText(name4[position]);
            }
            else if(currentMonth==2 ){
                imgHolyday.setImageResource(imgHolyday5[position]);
                name.setText(name5[position]);
            }


            return view;
        }
    }
    public void hideNavigator(){
        View decorView =getWindow().getDecorView();
        int uiOptions =View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |  View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
}
