package com.example.primer.trening;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton contest;
    ButtonPress bp = new ButtonPress();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contest = (ImageButton) findViewById(R.id.contest_button);
    }

    public void toContest(View view) {
        bp.Press(contest);

        Intent intent = new Intent(this, ContestActivity.class);

        startActivity(intent);
    }

    public void update(){
        System.out.println("doing stuff");
    }
}
