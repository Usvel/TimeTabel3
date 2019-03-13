package com.serma.crocobisunes.timetable;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        hideNavigator();

        final VideoView videoView = findViewById(R.id.video);
        Intent intent = getIntent();
        if (intent.getIntExtra("video",0)!=0) {
            Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/"
                    + intent.getIntExtra("video",0));
            videoView.setVideoURI(videoUri);
            videoView.start();
        }

        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }

    public void hideNavigator(){
        View decorView =getWindow().getDecorView();
        int uiOptions =View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |  View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    private Uri getUri(){
        return uri;
    }
}
