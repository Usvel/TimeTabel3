package com.serma.crocobisunes.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Achievement extends AppCompatActivity {
    int [] img={R.drawable.dahhhanartkhokhloma,R.drawable.picture,R.drawable.quilling,
            R.drawable.shariki};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);
        hideNavigator();
        GridView gridView=(GridView)findViewById(R.id.gridView);
        CustomAdapter customAdapter =new CustomAdapter();
        gridView.setAdapter(customAdapter);
        ImageButton back =(ImageButton) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Achievement.this,MainActivity.class);
                startActivity(intent);
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View full = getLayoutInflater().inflate(R.layout.fullscreen_img,null);
                ImageView fullscreen =(ImageView)full.findViewById(R.id.imgFullscreen);


                fullscreen.setImageResource(img[position]);

                setContentView(R.layout.fullscreen_img);

            }
        });

    }
    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return img.length;
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
            View view = getLayoutInflater().inflate(R.layout.item_image,null);
            ImageView imgHandmade =(ImageView) view.findViewById(R.id.imgHandmade);
            imgHandmade.setImageResource(img[position]);
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
