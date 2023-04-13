package com.example.easytax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SelecterPaymentLadderActivity extends AppCompatActivity {
    Intent intent = new Intent(SelecterPaymentLadderActivity.this,MainCalculateActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecter_payment_ladder);
    }
    private void goToCalculatePage(){
        startActivity(intent);
        finish();
    }
//    intent.putExtra("type","1");

}