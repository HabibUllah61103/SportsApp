package com.example.week_8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void signin_button(View view) {
        Intent login =new Intent(this, Sign_in_activity.class);
        startActivity(login);
    }

    public void signup_button(View view) {
        Intent signup =new Intent(this, sign_up_activity.class);
        startActivity(signup);
    }
}
