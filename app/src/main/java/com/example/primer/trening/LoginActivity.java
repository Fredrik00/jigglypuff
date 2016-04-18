package com.example.primer.trening;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;

public class LoginActivity extends AppCompatActivity {

    String string_email = "u";
    String string_password = "p";
    ImageButton login;
    ButtonPress bp = new ButtonPress();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (ImageButton) findViewById(R.id.sign_in_button);
    }

    public void toMain(View view) {
        bp.Press(login);

        Intent intent = new Intent(this, MainActivity.class);
        EditText password = (EditText) findViewById(R.id.password);
        AutoCompleteTextView email = (AutoCompleteTextView) findViewById(R.id.email);

        String input_email = email.getText().toString();
        String input_password = password.getText().toString();

        if (string_email.equals(input_email)  && string_password.equals(input_password)){
            startActivity(intent);
        }

        else{
            System.out.println(input_email);
            System.out.println(input_password);
        }
    }

}