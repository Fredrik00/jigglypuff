package com.example.primer.trening;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ContestActivity extends AppCompatActivity {

    ImageView box2;
    ImageButton imageButton;
    ImageView map;
    TextView info;
    ButtonPress bp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest);

        box2 = (ImageView) findViewById(R.id.box2);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        map = (ImageView) findViewById(R.id.map);
        info = (TextView) findViewById(R.id.info);

        bp = new ButtonPress();
    }

    public void extend(View view){
        box2.setAlpha((float) 1.0);
        map.setAlpha((float) 1.0);
        info.setAlpha(1);
    }

    public void select(View view){
        bp.Press(imageButton);
        onBackPressed();
    }
}
