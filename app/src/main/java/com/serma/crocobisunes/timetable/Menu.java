package com.serma.crocobisunes.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.serma.crocobisunes.timetable.R;

import java.util.Calendar;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    GridView gridView;

    int currentDay = 0;
    private ImageButton btnMonday,btnTuesday,btnWednesday,btnThursday,btnFriday,
            btnSaturday,btnSunday,btnBack;

    int day;
    int[] foodImages = {R.drawable.zavtrak, R.drawable.friedegg, R.drawable.porridge,R.drawable.coffee,
            R.drawable.obed,R.drawable.fish,R.drawable.vegetables,R.drawable.soup,R.drawable.poldnik,
            R.drawable.apple,R.drawable.water,R.drawable.cookies,R.drawable.ujin,R.drawable.salad,
            R.drawable.rice,R.drawable.tea,R.drawable.vechernik,R.drawable.glassmilk};

    int[] foodImages2 = {R.drawable.zavtrak, R.drawable.pancake, R.drawable.cheese,R.drawable.coffee,
            R.drawable.obed,R.drawable.hotsoup,R.drawable.cucumber,R.drawable.fish,R.drawable.poldnik,
            R.drawable.juicee, R.drawable.bread,R.drawable.tea1,R.drawable.ujin,R.drawable.salad,
            R.drawable.potato,R.drawable.water,R.drawable.vechernik,R.drawable.cookies,R.drawable.milk};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        hideNavigator();

        btnMonday =findViewById(R.id.btnMonday);
        btnTuesday =findViewById(R.id.btnTuesday);
        btnWednesday =findViewById(R.id.btnWednesday);
        btnThursday =findViewById(R.id.btnThursday);
        btnFriday =findViewById(R.id.btnFriday);
        btnSaturday =findViewById(R.id.btnSaturday);
        btnSunday =findViewById(R.id.btnSunday);
        btnBack =findViewById(R.id.back);

        btnMonday.setOnClickListener(this);
        btnTuesday.setOnClickListener(this);
        btnWednesday.setOnClickListener(this);
        btnThursday.setOnClickListener(this);
        btnFriday.setOnClickListener(this);
        btnSaturday.setOnClickListener(this);
        btnSunday.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);

        java.util.Calendar calendar = java.util.Calendar.getInstance();

        day = calendar.get(Calendar.DAY_OF_WEEK);

        setBackgroundDefaultColor();
        setBackgroundButton();



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), activity_grid_item.class);
                switch (currentDay) {
                    case 0:
                    intent.putExtra("image", foodImages[i]);
                    startActivity(intent);
               break;
                    case 1:
                    intent.putExtra("image", foodImages2[i]);
                    startActivity(intent);
                    break;
                    case 2:
                        intent.putExtra("image", foodImages[i]);
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("image", foodImages[i]);
                        startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra("image", foodImages[i]);
                        startActivity(intent);
                        break;
                    case 5:
                        intent.putExtra("image", foodImages[i]);
                        startActivity(intent);
                        break;
                    case 6:
                        intent.putExtra("image", foodImages[i]);
                        startActivity(intent);
                        break;
                }

            }
        });

    }

    public void hideNavigator(){
        View decorView =getWindow().getDecorView();
        int uiOptions =View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |  View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void setBackgroundButton(){
        switch (day){

            case java.util.Calendar.MONDAY:

                btnMonday.setBackgroundColor(getResources().getColor(R.color.GREEN));
                break;

            case java.util.Calendar.TUESDAY:

                btnTuesday.setBackgroundColor(getResources().getColor(R.color.GREEN));
                break;

            case java.util.Calendar.WEDNESDAY:

                btnWednesday.setBackgroundColor(getResources().getColor(R.color.GREEN));
                break;

            case java.util.Calendar.THURSDAY:

                btnThursday.setBackgroundColor(getResources().getColor(R.color.GREEN));
                break;

            case java.util.Calendar.FRIDAY:

                btnFriday.setBackgroundColor(getResources().getColor(R.color.GREEN));
                break;

            case java.util.Calendar.SATURDAY:

                btnSaturday.setBackgroundColor(getResources().getColor(R.color.GREEN));
                break;

            case java.util.Calendar.SUNDAY:

                btnSunday.setBackgroundColor(getResources().getColor(R.color.GREEN));
                break;

        }

    }

    public void dayClickedColor(int currentDay){

        if (currentDay+2 != day) {
            switch (currentDay) {
                case 0:
                    btnMonday.setBackgroundColor(getResources().getColor(R.color.BLUE));
                    break;
                case 1:
                    btnTuesday.setBackgroundColor(getResources().getColor(R.color.BLUE));
                    break;
                case 2:
                    btnWednesday.setBackgroundColor(getResources().getColor(R.color.BLUE));
                    break;
                case 3:
                    btnThursday.setBackgroundColor(getResources().getColor(R.color.BLUE));
                    break;
                case 4:
                    btnFriday.setBackgroundColor(getResources().getColor(R.color.BLUE));
                    break;
                case 5:
                    btnSaturday.setBackgroundColor(getResources().getColor(R.color.BLUE));
                    break;
                case 6:
                    btnSunday.setBackgroundColor(getResources().getColor(R.color.BLUE));
                    break;
            }
        }
    }

    public void clearBackgroundColor(int day,int currentDay){
        if (currentDay+2 != day) {
            switch (currentDay) {
                case 0:
                    btnMonday.setBackgroundColor(getResources().getColor(R.color.WHITE));
                    break;
                case 1:
                    btnTuesday.setBackgroundColor(getResources().getColor(R.color.WHITE));
                    break;
                case 2:
                    btnWednesday.setBackgroundColor(getResources().getColor(R.color.WHITE));
                    break;
                case 3:
                    btnThursday.setBackgroundColor(getResources().getColor(R.color.WHITE));
                    break;
                case 4:
                    btnFriday.setBackgroundColor(getResources().getColor(R.color.WHITE));
                    break;
                case 5:
                    btnSaturday.setBackgroundColor(getResources().getColor(R.color.WHITE));
                    break;
                case 6:
                    btnSunday.setBackgroundColor(getResources().getColor(R.color.WHITE));
                    break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        GridView gridView= findViewById(R.id.gridview);
        CustomAdapter customAdapter =new CustomAdapter();
        clearBackgroundColor(day,currentDay);

        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.btnMonday:
                currentDay=0;
                dayClickedColor(currentDay);
                break;
            case R.id.btnTuesday:
                currentDay=1;
                dayClickedColor(currentDay);
                break;
            case R.id.btnWednesday:
                currentDay=2;
                dayClickedColor(currentDay);
                break;
            case R.id.btnThursday:
                currentDay=3;
                dayClickedColor(currentDay);
                break;
            case R.id.btnFriday:
                currentDay=4;
                dayClickedColor(currentDay);
                break;
            case R.id.btnSaturday:
                currentDay=5;
                dayClickedColor(currentDay);
                break;

            case R.id.btnSunday:
                currentDay=6;
                dayClickedColor(currentDay);
                break;


        }
        gridView.setAdapter(customAdapter);

    }

    public void setBackgroundDefaultColor(){

        btnMonday.setBackgroundColor(getResources().getColor(R.color.WHITE));
        btnTuesday.setBackgroundColor(getResources().getColor(R.color.WHITE));
        btnWednesday.setBackgroundColor(getResources().getColor(R.color.WHITE));
        btnThursday.setBackgroundColor(getResources().getColor(R.color.WHITE));
        btnFriday.setBackgroundColor(getResources().getColor(R.color.WHITE));
        btnSaturday.setBackgroundColor(getResources().getColor(R.color.WHITE));
        btnSunday.setBackgroundColor(getResources().getColor(R.color.WHITE));
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return foodImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            ImageView image = view1.findViewById(R.id.images);
           switch (currentDay){
               case 0:

                image.setImageResource(foodImages[i]);
                    break;
               case 1:

                image.setImageResource(foodImages2[i]);
                break;
               case 2:

                   image.setImageResource(foodImages[i]);
                   break;
               case 3:

                   image.setImageResource(foodImages[i]);
                   break;
               case 4:

                   image.setImageResource(foodImages[i]);
                   break;
               case 5:

                   image.setImageResource(foodImages[i]);
                   break;
               case 6:

                   image.setImageResource(foodImages[i]);
                   break;

                }
            return view1;
        }

    }
}
