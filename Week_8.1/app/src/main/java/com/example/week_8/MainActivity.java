package com.example.week_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button btnLogin;
    private GetInfo getinfo;
    private String info_main;
    public TextView lbl1;
    public TextView lbl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getinfo = new GetInfo();
        getinfo.start();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lbl1 = findViewById(R.id.lbl1);
        lbl2 = findViewById(R.id.lbl2);

        info_main="";

    }

    public void show_info(View v)
    {
        runOnUiThread(() -> info_main = getinfo.info);
        // runOnUiThread is a method of Activity class,
        // it runs the specified action on the UI (this Activity) thread.
        // '->' is the Lambda Operator used in all Lambda Expressions
        // Lambda expressions allow passing a function as an input parameter for another function,
        // which was not possible before Java version 8

        String AdP;
        String UsrP;

        AdP = UsrP = "";

        // AdPass<<>>UsrPass

        if (info_main != "") {
            AdP = info_main.substring(0, info_main.indexOf("<<>>"));
            UsrP = info_main.substring(info_main.indexOf("<<>>") + 4, info_main.length());
            lbl1.setText(AdP);
            lbl2.setText(UsrP);
        }else{
            Toast.makeText(getApplicationContext(),"Retry", Toast.LENGTH_LONG).show();
        }
    }
}