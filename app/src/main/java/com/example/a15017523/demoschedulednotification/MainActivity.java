package com.example.a15017523.demoschedulednotification;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    int reqCode = 12345;
    Button buttonSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSchedule = (Button)findViewById(R.id.btnSchedule);

        buttonSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                calendar.add(calendar.SECOND, 5);
                Intent intent = new Intent(MainActivity.this,
                        ScheduledNotificationReceiver.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, reqCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager alarmManager = (AlarmManager)getSystemService(Activity.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }
        });
    }
}
