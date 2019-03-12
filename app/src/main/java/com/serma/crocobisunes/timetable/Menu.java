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

public class Menu extends AppCompatActivity implements View.OnClickListener {
    GridView gridView;

    int currentDay = 0;
    private ImageButton btnMonday,btnTuesday,btnWednesday,btnThursday,btnFriday,
            btnSaturday,btnSunday,btnBack;

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

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), activity_grid_item.class);
                if(currentDay==0) {
                    intent.putExtra("image", foodImages[i]);
                    startActivity(intent);
                } else if (currentDay==1){
                    intent.putExtra("image", foodImages2[i]);
                    startActivity(intent);
                }

            }
        });

    }

    @Override
    public void onClick(View view) {
        GridView gridView= findViewById(R.id.gridview);
        CustomAdapter customAdapter =new CustomAdapter();

        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.btnMonday:
                currentDay=0;

                break;
            case R.id.btnTuesday:
                currentDay=1;
                break;
            case R.id.btnWednesday:
                currentDay=2;
                break;
            case R.id.btnThursday:
                currentDay=3;
                break;
            case R.id.btnFriday:
                currentDay=4;
                break;
            case R.id.btnSaturday:
                currentDay=5;
                break;

            case R.id.btnSunday:
                currentDay=6;
                break;


        }
        gridView.setAdapter(customAdapter);

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
            if(currentDay==0) {
                ImageView image = view1.findViewById(R.id.images);
                image.setImageResource(foodImages[i]);

            } else if(currentDay==1) {
                ImageView image = view1.findViewById(R.id.images);
                image.setImageResource(foodImages2[i]);
                }
            return view1;
        }

    }
}
