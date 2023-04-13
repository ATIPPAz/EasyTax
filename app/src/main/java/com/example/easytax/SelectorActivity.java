package com.example.easytax;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class SelectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        SharedPreferences sharedPreferences = getSharedPreferences("EasyTax", Context.MODE_PRIVATE);
    }
    public void goToUserNamePage(View view){
            Intent intent = new Intent(SelectorActivity.this,UserNameActivity.class);
            startActivity(intent);
            finish();
    }
    public void flatPaymentClick(View view){
        Intent intent = new Intent(SelectorActivity.this,MainCalculateActivity.class);
        intent.putExtra("type","1");
        startActivity(intent);
    }
    public void payStepLadder(View view){
        Intent intent = new Intent(SelectorActivity.this, SelectorPaymentLadderActivity.class);
        startActivity(intent);
    }
}