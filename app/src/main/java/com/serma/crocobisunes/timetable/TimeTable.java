package com.serma.crocobisunes.timetable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
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
import java.util.Calendar;

public class TimeTable extends AppCompatActivity implements View.OnClickListener {

    private Animator mCurrentAnimator;
    private int mShortAnimationDuration;
    private ImageButton btnMonday,btnTuesday,btnWednesday,btnThursday,btnFriday,
            btnSaturday,btnSunday;

    int day;
    int [] imgCouch ={R.drawable.facedetection,R.drawable.smile,R.drawable.spa};
    int [] imgTimePn={R.drawable.clock,R.drawable.t1300,R.drawable.t1500};
    int[] imgActionPn ={R.drawable.plateforkandknife,R.drawable.trekking,
            R.drawable.slumber};
    int [] imgTimeVt={R.drawable.clock,R.drawable.clock,R.drawable.clock};
    int[] imgActionVt ={R.drawable.slumber,R.drawable.trekking,
            R.drawable.plateforkandknife};
    int [] videoPn = {R.raw.charging,R.raw.charging,R.raw.charging};
  //  String[] dayOfWeek ={"Понедельник","Вторник","Среда","Четверг","Пятница","Суббота","Воскресенье"};
    public int currentDay=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        btnMonday =findViewById(R.id.btnMonday);
        btnTuesday =findViewById(R.id.btnTuesday);
        btnWednesday =findViewById(R.id.btnWednesday);
        btnThursday =findViewById(R.id.btnThursday);
        btnFriday =findViewById(R.id.btnFriday);
        btnSaturday =findViewById(R.id.btnSaturday);
        btnSunday =findViewById(R.id.btnSunday);

        btnMonday.setOnClickListener(this);
        btnTuesday.setOnClickListener(this);
        btnWednesday.setOnClickListener(this);
        btnThursday.setOnClickListener(this);
        btnFriday.setOnClickListener(this);
        btnSaturday.setOnClickListener(this);
        btnSunday.setOnClickListener(this);

        final ImageView imgFullScreen = (ImageView) findViewById(R.id.imgFullscreen);
        ListView listView=(ListView) findViewById(R.id.listTimetable);
        CustomAdapter customAdapter =new CustomAdapter();
        listView.setAdapter(customAdapter);
        hideNavigator();
        listView.setItemsCanFocus(true);
        listView.setFocusable(false);
        listView.setFocusableInTouchMode(false);
        listView.setClickable(false);

        java.util.Calendar calendar = java.util.Calendar.getInstance();

        day = calendar.get(Calendar.DAY_OF_WEEK);

        ImageButton backToMain = (ImageButton) findViewById(R.id.back);
        backToMain.setOnClickListener(TimeTable.this);



        setBackgroundDefaultColor();
        setBackgroundButton();
//        final View thumb1View = findViewById(R.id.action);
//        thumb1View.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                zoomImageFromThumb(thumb1View, R.drawable.picture);
//            }
//        });
//
//        mShortAnimationDuration = getResources().getInteger(
//                android.R.integer.config_shortAnimTime);

    }

    public void hideNavigator(){
        View decorView =getWindow().getDecorView();
        int uiOptions =View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |  View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void setBackgroundButton(){
        switch (day){

            case Calendar.MONDAY:

                btnMonday.setBackgroundColor(getResources().getColor(R.color.GREEN));
               break;

            case Calendar.TUESDAY:

                btnTuesday.setBackgroundColor(getResources().getColor(R.color.GREEN));
                break;

            case Calendar.WEDNESDAY:

                btnWednesday.setBackgroundColor(getResources().getColor(R.color.GREEN));
                break;

            case Calendar.THURSDAY:

                btnThursday.setBackgroundColor(getResources().getColor(R.color.GREEN));
                break;

            case Calendar.FRIDAY:

                btnFriday.setBackgroundColor(getResources().getColor(R.color.GREEN));
                break;

            case Calendar.SATURDAY:

                btnSaturday.setBackgroundColor(getResources().getColor(R.color.GREEN));
                break;

            case Calendar.SUNDAY:

                btnSunday.setBackgroundColor(getResources().getColor(R.color.GREEN));
                break;

        }

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

    @Override
    public void onClick(View view) {
        ListView listView=(ListView) findViewById(R.id.listTimetable);
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
        listView.setAdapter(customAdapter);

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
        public View getView(final int position, View convertView, ViewGroup parent) {
            final View view = getLayoutInflater().inflate(R.layout.item_list_view,null);
            final ImageView btnChecked = (ImageView) view.findViewById(R.id.btnChecked);
            ImageView time =(ImageView) view.findViewById(R.id.time);
            ImageButton btnAction =(ImageButton) view.findViewById(R.id.action);
            final ImageView couch =(ImageView) view.findViewById(R.id.couch);
            switch (currentDay){
                case 0:
                time.setImageResource(imgTimePn[position]);
                btnAction.setImageResource(imgActionPn[position]);
                couch.setImageResource(imgCouch[position]);
                break;

            case 1:

                time.setImageResource(imgTimeVt[position]);
                btnAction.setImageResource(imgActionVt[position]);
                couch.setImageResource(imgCouch[position]);
                break;
                case 2:
                    time.setImageResource(imgTimePn[position]);
                    btnAction.setImageResource(imgActionPn[position]);
                    couch.setImageResource(imgCouch[position]);
                    break;
                case 3:
                    time.setImageResource(imgTimePn[position]);
                    btnAction.setImageResource(imgActionPn[position]);
                    couch.setImageResource(imgCouch[position]);
                    break;
                case 4:
                    time.setImageResource(imgTimePn[position]);
                    btnAction.setImageResource(imgActionPn[position]);
                    couch.setImageResource(imgCouch[position]);
                    break;
                case 5:
                    time.setImageResource(imgTimePn[position]);
                    btnAction.setImageResource(imgActionPn[position]);
                    couch.setImageResource(imgCouch[position]);
                    break;
                case 6:
                    time.setImageResource(imgTimePn[position]);
                    btnAction.setImageResource(imgActionPn[position]);
                    couch.setImageResource(imgCouch[position]);
                    break;
            }

            btnChecked.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("MSG",btnChecked.getAlpha() + "");
                    if (btnChecked.getAlpha() == 0.5f){
                        btnChecked.animate().alpha(1f).start();
                    }
                    else {
                        btnChecked.animate().alpha(0.5f).start();
                    }
                }
            });

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("tag","msg");
                        Intent intent =new Intent(TimeTable.this,FullscreenImg.class);
                       switch (currentDay){
                           case 0:
                            intent.putExtra("Drawable", imgActionPn[position]);
                            intent.putExtra("video", videoPn[position]);
                            Log.i("tag", intent.getIntExtra("Drawable", 0) + "");
                        break;
                           case 1:
                            intent.putExtra("Drawable", imgActionVt[position]);
                            intent.putExtra("video", videoPn[position]);
                            Log.i("tag", intent.getIntExtra("Drawable", 0) + "");
                            break;
                           case 2:
                               intent.putExtra("Drawable", imgActionPn[position]);
                               intent.putExtra("video", videoPn[position]);
                               Log.i("tag", intent.getIntExtra("Drawable", 0) + "");
                               break;
                           case 3:
                               intent.putExtra("Drawable", imgActionPn[position]);
                               intent.putExtra("video", videoPn[position]);
                               Log.i("tag", intent.getIntExtra("Drawable", 0) + "");
                               break;
                           case 4:
                               intent.putExtra("Drawable", imgActionPn[position]);
                               intent.putExtra("video", videoPn[position]);
                               Log.i("tag", intent.getIntExtra("Drawable", 0) + "");
                               break;
                           case 5:
                               intent.putExtra("Drawable", imgActionPn[position]);
                               intent.putExtra("video", videoPn[position]);
                               Log.i("tag", intent.getIntExtra("Drawable", 0) + "");
                               break;
                           case 6:
                               intent.putExtra("Drawable", imgActionPn[position]);
                               intent.putExtra("video", videoPn[position]);
                               Log.i("tag", intent.getIntExtra("Drawable", 0) + "");
                               break;
                        }
                          startActivity(intent);
                    }
                });

            couch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("tag","msg");
                    Intent intent =new Intent(TimeTable.this,FullscreenImg.class);

                    intent.putExtra("Drawable",imgCouch[position]);

                    Log.i("tag",intent.getIntExtra("Drawable",0) + "");


                    startActivity(intent);
                }
            });


            return view;
        }
    }
//    private void zoomImageFromThumb(final View thumbView, int imageResId) {
//        if (mCurrentAnimator != null) {
//            mCurrentAnimator.cancel();
//        }
//
//        final ImageView expandedImageView = (ImageView) findViewById(
//                R.id.expanded_image);
//        expandedImageView.setImageResource(imageResId);
//
//        final Rect startBounds = new Rect();
//        final Rect finalBounds = new Rect();
//        final Point globalOffset = new Point();
//
//        thumbView.getGlobalVisibleRect(startBounds);
//        findViewById(R.id.container)
//                .getGlobalVisibleRect(finalBounds, globalOffset);
//        startBounds.offset(-globalOffset.x, -globalOffset.y);
//        finalBounds.offset(-globalOffset.x, -globalOffset.y);
//
//        float startScale;
//        if ((float) finalBounds.width() / finalBounds.height()
//                > (float) startBounds.width() / startBounds.height()) {
//            // Extend start bounds horizontally
//            startScale = (float) startBounds.height() / finalBounds.height();
//            float startWidth = startScale * finalBounds.width();
//            float deltaWidth = (startWidth - startBounds.width()) / 2;
//            startBounds.left -= deltaWidth;
//            startBounds.right += deltaWidth;
//        } else {
//            // Extend start bounds vertically
//            startScale = (float) startBounds.width() / finalBounds.width();
//            float startHeight = startScale * finalBounds.height();
//            float deltaHeight = (startHeight - startBounds.height()) / 2;
//            startBounds.top -= deltaHeight;
//            startBounds.bottom += deltaHeight;
//        }
//
//        thumbView.setAlpha(0f);
//        expandedImageView.setVisibility(View.VISIBLE);
//
//        expandedImageView.setPivotX(0f);
//        expandedImageView.setPivotY(0f);
//
//        AnimatorSet set = new AnimatorSet();
//        set.play(ObjectAnimator.ofFloat(expandedImageView, View.X,
//                startBounds.left, finalBounds.left))
//                .with(ObjectAnimator.ofFloat(expandedImageView, View.Y,
//                        startBounds.top, finalBounds.top))
//                .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_X,
//                        startScale, 1f)).with(ObjectAnimator.ofFloat(expandedImageView,
//                View.SCALE_Y, startScale, 1f));
//        set.setDuration(mShortAnimationDuration);
//        set.setInterpolator(new DecelerateInterpolator());
//        set.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                mCurrentAnimator = null;
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//                mCurrentAnimator = null;
//            }
//        });
//        set.start();
//        mCurrentAnimator = set;
//
//        final float startScaleFinal = startScale;
//        expandedImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (mCurrentAnimator != null) {
//                    mCurrentAnimator.cancel();
//                }
//
//                AnimatorSet set = new AnimatorSet();
//                set.play(ObjectAnimator
//                        .ofFloat(expandedImageView, View.X,    startBounds.left))
//                        .with(ObjectAnimator
//                                .ofFloat(expandedImageView,
//                                        View.Y,startBounds.top))
//                        .with(ObjectAnimator
//                                .ofFloat(expandedImageView,
//                                        View.SCALE_X, startScaleFinal))
//                        .with(ObjectAnimator
//                                .ofFloat(expandedImageView,
//                                        View.SCALE_Y, startScaleFinal));
//                set.setDuration(mShortAnimationDuration);
//                set.setInterpolator(new DecelerateInterpolator());
//                set.addListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        thumbView.setAlpha(1f);
//                        expandedImageView.setVisibility(View.GONE);
//                        mCurrentAnimator = null;
//                    }
//
//                    @Override
//                    public void onAnimationCancel(Animator animation) {
//                        thumbView.setAlpha(1f);
//                        expandedImageView.setVisibility(View.GONE);
//                        mCurrentAnimator = null;
//                    }
//                });
//                set.start();
//                mCurrentAnimator = set;
//            }
//        });
//    }
}
