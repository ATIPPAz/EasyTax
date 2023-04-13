package com.example.easytax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainCalculateActivity extends AppCompatActivity {

    String type = "1";
    String typePayment = "1";

    String typeText = "";
    double totalMoney = 0;
    double additional = 0;
    double limitMoney= 0;
    double taxRate = 0;
    double totalTax = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculate);
        Button btn = findViewById(R.id.calculateButton);
        Intent intent = getIntent();
        typePayment = intent.getStringExtra("type");
        setup();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(typePayment=="1"){
                    calculateTaxFlatPayment();
                }
                else{
                    calculateTax();
                }
            }
        });
    }
    private void calculateTax(){
        totalTax = ((totalMoney-limitMoney)*taxRate)+additional;
    }
    private void calculateTaxFlatPayment(){
        totalTax = ((totalMoney-limitMoney)*taxRate)+additional;
    }
    public void setup(){
        if(type == "1"){
            typeText = "แบบเหมาจ่าย";
        }
        else if(type== "2"){
            typeText = "ไม่เกิน 150,000 บาท ขั้นบันได 0%";
            taxRate = 0;
            additional = 0;
            limitMoney= 0;
        }
        else if(type== "3"){
            typeText = "150,001-300,000 ขั้นบันได 5%บาท";
            taxRate = 5/100;
            additional = 0;
            limitMoney= 150000;
        }
        else if(type== "4"){
            typeText = "300,001-500,000 ขั้นบันได 10%บาท";
            taxRate = 10/100;
            additional = 7500;
            limitMoney= 300000;
        }
        else if(type== "5"){
            typeText = "500,001-750,000 ขั้นบันได 15%บาท";
            taxRate = 15/100;
            additional = 27500;
            limitMoney= 500000;
        }
        else if(type== "6"){
            typeText = "750001-1,000,000 ขั้นบันได 20%บาท";
            taxRate = 20/100;
            additional = 65000;
            limitMoney= 750000;
        }
        else if(type== "7"){
            typeText = "1,000,001-2,000,000 ขั้นบันได 25%บาท";
            taxRate = 25/100;
            additional = 11500;
            limitMoney=1000000;
        }
        else if(type== "8"){
            typeText = "2,000,001-5,000,000 ขั้นบันได 30%บาท";
            taxRate = 30/100;
            additional = 365000;
            limitMoney=2000000;
        }
        else if(type== "9"){
            typeText = "มากกว่า 5,000,000 ขั้นบันได 35%บาท";
            taxRate = 35/100;
            additional = 1265000;
            limitMoney=5000000;
        }
    }
}