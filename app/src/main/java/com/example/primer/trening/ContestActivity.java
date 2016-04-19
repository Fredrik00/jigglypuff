package com.example.primer.trening;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ContestActivity extends AppCompatActivity {
    Handler handler;
    TextView timeLeft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest);

        timeLeft = (TextView) findViewById(R.id.time_text);
        calculateTimeLeft();

        handler=new Handler();

        final Runnable updateTask=new Runnable() {
            @Override
            public void run() {
                calculateTimeLeft();
                handler.postDelayed(this,1000);
            }
        };

        handler.postDelayed(updateTask, 1000);
    }

    public void calculateTimeLeft() {
        // TODO Auto-generated method stub
        int day = 0;
        int hh = 0;
        int mm = 0;
        int ss = 0;
        try
        {
            Date endDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2016-06-01 00:00:00");
            //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //Date endDate = dateFormat.parse(endTime);
            Date currentDate = new Date();
            Long timeDiff = endDate.getTime() - currentDate.getTime();
            day = (int) TimeUnit.MILLISECONDS.toDays(timeDiff);
            hh = (int) (TimeUnit.MILLISECONDS.toHours(timeDiff) - TimeUnit.DAYS.toHours(day));
            mm = (int) (TimeUnit.MILLISECONDS.toMinutes(timeDiff) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeDiff)));
            ss = (int) (TimeUnit.MILLISECONDS.toSeconds(timeDiff) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeDiff)));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        if(day==0)
        {
            timeLeft.setText("Time left: " + hh + ":" + mm + ":" + ss);
        }
        else if(hh==0)
        {
            timeLeft.setText("Time left: " + mm + ":" + ss);
        }
        else
        {
            timeLeft.setText("Time left: " + day + ":" + hh + ":" + mm + ":" + ss);
        }
    }
}
