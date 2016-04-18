package com.example.primer.trening;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    String string_email = "u";
    String string_password = "p";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void toMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText password = (EditText) findViewById(R.id.password);
        AutoCompleteTextView email = (AutoCompleteTextView) findViewById(R.id.email);

        String input_email = email.getText().toString();
        String input_password = password.getText().toString();

        if (string_email.equals(input_email)  && string_password.equals(input_password)){
            startActivity(intent);
        }

        else{
            System.out.println("##########################################");
            System.out.println(input_email);
            System.out.println(input_password);
        }
    }

}