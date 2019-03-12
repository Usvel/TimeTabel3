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

    private Uri getUri(){
        return uri;
    }
}
