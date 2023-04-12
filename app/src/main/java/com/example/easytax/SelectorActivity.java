package com.example.easytax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SelectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
        TextView username = findViewById(R.id.nameTv);
        SharedPreferences sharedPreferences = getSharedPreferences("EasyTax", Context.MODE_PRIVATE);
        username.setText(sharedPreferences.getAll().get("username").toString());
    }
}