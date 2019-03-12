package com.cyberessence.cyberorangeteam.game;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.serma.crocobisunes.timetable.MainActivity;
import com.serma.crocobisunes.timetable.R;

public class Scale extends MainActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton eating = (ImageButton) findViewById(R.id.eating);

        eating.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.scale);
                eating.startAnimation(animation);
            }
        });
    }
}
