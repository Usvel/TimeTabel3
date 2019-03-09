
package com.serma.crocobisunes.timetable;

        import android.app.Dialog;
        import android.app.TimePickerDialog;
        import android.content.Intent;
        import android.content.pm.ActivityInfo;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageButton;
        import android.widget.TextView;
        import android.widget.TimePicker;
        import android.widget.Toast;

public class myTimetable extends AppCompatActivity {

    ImageButton shower;
    ImageButton food;
    ImageButton talk;
    ImageButton walk;

    TimePicker timePicker;

    private int mHour = 0;
    private int mMin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_timetable);

    hideNavigator();
        //ImageButton для картинки душа
        shower = (ImageButton) findViewById(R.id.shower);

        shower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Вы выбрали душ", Toast.LENGTH_SHORT).show();

                //Переход на новое activity TimeTable
                Intent intent = new Intent(myTimetable.this,ChoosenTimetable.class);
                intent.putExtra("shower", "Принять душ");
                timePicker = (TimePicker) findViewById(R.id.timePicker);
                startActivity(intent);

            }
        });

        //ImageButton для картинки еды
        food = (ImageButton) findViewById(R.id.food);

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Вы выбрали еду", Toast.LENGTH_SHORT).show();

                //Переход на новое activity TimeTable
                Intent intent = new Intent(myTimetable.this,ChoosenTimetable.class);
                intent.putExtra("food", "Поесть");
                startActivity(intent);

            }
        });

        //ImageButton для картинки прогулки
        walk = (ImageButton) findViewById(R.id.walk);

        walk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Сообщение для специалиста
                //Toast.makeText(MainActivity.this, "Вы выбрали прогулку", Toast.LENGTH_SHORT).show();

                //Переход на новое activity TimeTable
                Intent intent = new Intent(myTimetable.this,ChoosenTimetable.class);
                intent.putExtra("walk", "Погулять");
                startActivity(intent);

            }
        });

        //ImageButton для картинки общения
        talk = (ImageButton) findViewById(R.id.talk);

        talk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Вы выбрали общение", Toast.LENGTH_SHORT).show();

                //Переход на новое activity TimeTable
                Intent intent = new Intent(myTimetable.this,ChoosenTimetable.class);
                intent.putExtra("talk", "Общение");
                startActivity(intent);

            }
        });
    }
    public void hideNavigator(){
        View decorView =getWindow().getDecorView();
        int uiOptions =View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |  View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
    // слушатель, который вызывается при нажатии на кнопку Задать
    private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker timePicker, int hour, int minute) {
            mHour = hour; // устанавливаем часы
            mMin = minute; // устанавливаем минуты
            updateTextView(); // обновляем TextView
        }
    };

    private static final int TIME_DIALOG_ID = 0; // уникальный идентификатор для диалога выбора времени


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID: // если наш диалог
                return new TimePickerDialog(this, mTimeSetListener, mHour, mMin, true);
        }
        return null;
    }


    public void setTime(View view) {
        showDialog(TIME_DIALOG_ID); // вызов диалога
    }


    private void updateTextView() {
        TextView tw = (TextView)this.findViewById(R.id.time); // ищем TextView
        tw.setText(pad(mHour) + ":" + pad(mMin)); // устанавливаем текст
    }


    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
}
