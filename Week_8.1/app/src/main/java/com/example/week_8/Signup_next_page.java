package com.example.week_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Signup_next_page extends AppCompatActivity {
    EditText name;
    private ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_next_page);
        UserManager userManager = UserManager.getInstance();
        users = userManager.getUsers();  // Get the shared list of users

        // If the shared list of users is empty, initialize with pre-existing users
        if (users.isEmpty()) {
            ArrayList<User> preExistingUsers = initializeUsers();
            users.addAll(preExistingUsers);
        }
    }


    public void signup_final_click (View view){
        name = findViewById(R.id.signup_name);
        Intent signup_next =getIntent();
        String email = signup_next.getStringExtra("email");
        String password = signup_next.getStringExtra("password");
        String enteredname = name.getText().toString();
        users.add(new User(email, password, enteredname));
        Toast.makeText(this, "Signup successful!", Toast.LENGTH_SHORT).show();
    }

    public static class User implements Serializable {
        public String email;
        public String password;
        public String name;

        public User(String email, String password, String name) {
            this.email = email;
            this.password = password;
            this.name = name;
        }
    }

    private ArrayList<User> initializeUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("habib@email.com", "password1", "habib"));
        users.add(new User("maaz@email.com", "password2", "maaz"));
        // ... add other pre-existing users
        return users;
    }
}