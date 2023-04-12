package com.example.easytax;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Intent intent =null;
        SharedPreferences sharedPreferences = getSharedPreferences("EasyTax", Context.MODE_PRIVATE);
        if(!sharedPreferences.contains("username")){
            String value = sharedPreferences.getString("username", null);
            if (value != null){
                intent = new Intent(MainActivity.this, SelectorActivity.class);
            }
            else{
                intent = new Intent(MainActivity.this, UserNameActivity.class);
            }
        }
        else{
            intent = new Intent(MainActivity.this, SelectorActivity.class);
        }
        startActivity(intent);
        finish();
    }
}