package com.example.week_8;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String itemName = intent.getStringExtra("itemName");
        String itemNum = intent.getStringExtra("itemNum");
        String itemDetails = intent.getStringExtra("itemdetails");
        int itemImage = intent.getIntExtra("itemImage", 0);

        TextView txtItemName = findViewById(R.id.txtItemName);
        TextView txtItemNum = findViewById(R.id.txtItemNum);
        TextView txtItemDetail = findViewById(R.id.txtItemDetail);
        ImageView imgDetail = findViewById(R.id.imgDetail);

        txtItemName.setText(itemName);
        txtItemNum.setText(itemNum);
        txtItemDetail.setText(itemDetails);
        imgDetail.setImageResource(itemImage);
    }
}