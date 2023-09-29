package com.example.week_8;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.week_8.api.Chatfragment;
import com.example.week_8.api.Homefragment;
import com.example.week_8.api.Profilefragment;
import com.example.week_8.api.Searchfragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NewsDetailActivity extends AppCompatActivity {
    TextView username;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navbar);
        Intent discover = getIntent();
        String name = discover.getStringExtra("username");
        username = findViewById(R.id.textView);
        username.setText("Welcome, " + name);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        if (savedInstanceState == null) {
            loadFragment(new Homefragment());
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            @SuppressLint("NonConstantResourceId") Fragment fragment = switch (menuItem.getItemId()) {
                case R.id.search -> new Searchfragment();
                case R.id.chat -> new Chatfragment();
                case R.id.profile -> new Profilefragment();
                default -> new Homefragment();
            };
            return loadFragment(fragment);
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
