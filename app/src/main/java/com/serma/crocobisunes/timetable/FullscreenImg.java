package com.serma.crocobisunes.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class FullscreenImg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_img);

        ImageView imageView = findViewById(R.id.imgFullscreen);
        final Intent intent = getIntent();

        Log.i("tag",intent.getIntExtra("Drawable",0) + "");

        if (intent.getIntExtra("Drawable",0) != 0) {


            imageView.setImageResource(intent.getIntExtra("Drawable",0));
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (intent.getIntExtra("video", 0) != 0) {
                    Intent intent1 = new Intent(FullscreenImg.this, Video.class);
                    intent1.putExtra("video", intent.getIntExtra("video", 0));
                    startActivity(intent1);
                    finish();
                } else
                    finish();
            }

        });
    }
}
