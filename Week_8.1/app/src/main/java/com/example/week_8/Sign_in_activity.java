package com.example.week_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Sign_in_activity extends AppCompatActivity {
    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getIntent();
        email = findViewById(R.id.sigin_email);
        password = findViewById(R.id.sigin_password);
    }

    public void signin_click (View view){
        UserManager userManager = UserManager.getInstance();
        ArrayList<Signup_next_page.User> users = userManager.getUsers();

        String enteredEmail = email.getText().toString();
        String enteredPassword = password.getText().toString();
        String username = "";

        boolean isAuthenticated = false;

        for (Signup_next_page.User user : users) {
            if (user.email.equals(enteredEmail) && user.password.equals(enteredPassword)) {
                isAuthenticated = true;
                username = user.name;
                break;
            }
        }

        if (isAuthenticated) {
            // User authenticated successfully
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
            Intent discover = new Intent(this, NewsDetailActivity.class);
            discover.putExtra("username", username);
            startActivity(discover);
            finish();

        } else {
            Toast.makeText(this, "Invalid credentials!", Toast.LENGTH_SHORT).show();
        }
    }
}