package com.example.week_8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class sign_up_activity extends AppCompatActivity {
    EditText email;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getIntent();
    }

    public void signup_next_click(View view) {
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);
        Intent signup_next =new Intent(this, Signup_next_page.class);
        String enteredemail = email.getText().toString();
        String enteredpassword = password.getText().toString();
        signup_next.putExtra("email",enteredemail);
        signup_next.putExtra("password",enteredpassword);
        startActivity(signup_next);
    }
}