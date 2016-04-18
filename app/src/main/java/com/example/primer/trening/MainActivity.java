package com.example.primer.trening;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton contest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contest = (ImageButton) findViewById(R.id.contest_button);
    }

    public void toContest(View view) {
        contest.setColorFilter(Color.argb(100, 0, 0, 0));

        new CountDownTimer(300, 300){
            public void onFinish(){
                contest.setColorFilter(Color.argb(0, 0, 0, 0));
            }

            public void onTick(long millisUntilFinished){
            }
        }.start();

        Intent intent = new Intent(this, ContestActivity.class);

        startActivity(intent);
    }
}
