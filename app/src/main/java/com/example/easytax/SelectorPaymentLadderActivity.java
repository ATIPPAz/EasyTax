package com.example.easytax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SelectorPaymentLadderActivity extends AppCompatActivity {
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecter_payment_ladder);
        intent = new Intent(SelectorPaymentLadderActivity.this,MainCalculateActivity.class);
    }
    private void goToCalculatePage(){
        startActivity(intent);
        finish();
    }
//    intent.putExtra("type","1");

}