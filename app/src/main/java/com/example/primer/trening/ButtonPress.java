package com.example.primer.trening;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.ImageButton;

/**
 * Created by Fredrik on 19/04/2016.
 */
public class ButtonPress {
    ImageButton button;

    public void Press(ImageButton b) {
        button = b;
        button.setColorFilter(Color.argb(100, 0, 0, 0));

        new CountDownTimer(300, 300){
            public void onFinish(){
                button.setColorFilter(Color.argb(0, 0, 0, 0));
            }

            public void onTick(long millisUntilFinished){
            }
        }.start();
    }
}
