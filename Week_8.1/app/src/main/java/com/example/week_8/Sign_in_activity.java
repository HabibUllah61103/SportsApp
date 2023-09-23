package com.example.week_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Sign_in_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Intent login =getIntent();
    }

    public void signin_click (View view){
        Intent id_login = new Intent(this, Discover_page.class);
        startActivity(id_login);
    }
}