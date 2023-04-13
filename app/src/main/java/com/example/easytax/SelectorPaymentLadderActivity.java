package com.example.easytax;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SelectorPaymentLadderActivity extends AppCompatActivity {
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecter_payment_ladder);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        intent = new Intent(SelectorPaymentLadderActivity.this,MainCalculateActivity.class);
        TextView btn1 = findViewById(R.id.tvBtn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("type","2");
                openMainCalculate();
            }
        });
        TextView btn2 = findViewById(R.id.tvBtn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("type","3");
                openMainCalculate();
            }
        });
        TextView btn3 = findViewById(R.id.tvBtn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("type","4");
                openMainCalculate();
            }
        });
        TextView btn4 = findViewById(R.id.tvBtn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("type","5");
                openMainCalculate();
            }
        });
        TextView btn5 = findViewById(R.id.tvBtn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("type","6");
                openMainCalculate();
            }
        });
        TextView btn6 = findViewById(R.id.tvBtn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("type","7");
                openMainCalculate();
            }
        });
        TextView btn7 = findViewById(R.id.tvBtn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("type","8");
                openMainCalculate();
            }
        });
        TextView btn8 = findViewById(R.id.tvBtn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("type","9");
                openMainCalculate();
            }
        });


    }
private void openMainCalculate(){
    startActivity(intent);
}
//    intent.putExtra("type","1");

}