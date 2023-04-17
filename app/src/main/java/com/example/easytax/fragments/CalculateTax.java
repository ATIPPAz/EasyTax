package com.example.easytax.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easytax.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalculateTax#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculateTax extends Fragment {
    String type = "1";
    String taxRateS = "";
    double lowerBound = 0;
    double upperBound =0;
    EditText lightenEt = null;
    EditText revenueEt = null;
    EditText expensesEt = null;
    String typeText = "";
    double totalMoney = 0;
    double additional = 0;
    double limitMoney= 0;
    double taxRate = 0;
    double totalTax = 0;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CalculateTax() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalculateTax.
     */
    // TODO: Rename and change types and number of parameters
    public static CalculateTax newInstance(String param1, String param2) {
        CalculateTax fragment = new CalculateTax();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private double calculateTax(){
        Log.d("tax",String.valueOf(totalMoney) );
        Log.d("tax",String.valueOf(limitMoney) );
        Log.d("tax",String.valueOf(taxRate));
        Log.d("tax",String.valueOf(additional) );

       return ((totalMoney-limitMoney)*taxRate)+additional;
    }
    private double calculateTaxFlatPayment(){
        return  ((totalMoney-limitMoney)*taxRate)+additional;
    }
    public void setup(){
//        BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.btMenu);

        if(type.equals("1")){
            typeText = "แบบเหมาจ่าย";
            lowerBound = 1;
            upperBound =-1;
            taxRateS = "5%";
//            bottomNavigationView.setSelectedItemId(R.id.flat_tax);
            return;
        }
        else if(type.equals("2")){
            typeText = "ไม่เกิน 150,000 บาท\nขั้นบันได 0%";
            taxRateS = "0%";
            taxRate = 0;
            additional = 0;
            lowerBound = 1;
            upperBound =150000;
            limitMoney= 0;
        }
        else if(type.equals("3")){
            typeText = "150,001-300,000 บาท\nขั้นบันได 5%";
            taxRateS = "5%";
            taxRate = 5.0/100.0;
            additional = 0;
            lowerBound = 150001;
            upperBound =300000;
            limitMoney= 150000;
        }
        else if(type.equals("4")){
            typeText = "300,001-500,000 บาท\nขั้นบันได 10%";
            taxRate = 10.0/100.0;
            additional = 7500;
            taxRateS = "10%";
            limitMoney= 300000;
            lowerBound = 300001;
            upperBound =500000;
        }
        else if(type.equals("5")){
            typeText = "500,001-750,000 บาท\nขั้นบันได 15%";
            taxRateS = "15%";
            taxRate = 15.0/100.0;
            additional = 27500;
            lowerBound = 500001;
            upperBound =750000;
            limitMoney= 500000;
        }
        else if(type.equals("6")){
            typeText = "750001-1,000,000 บาท\nขั้นบันได 20%";
            taxRateS = "20%";
            taxRate = 20.0/100.0;
            additional = 65000;
            limitMoney= 750000;
            lowerBound = 750001;
            upperBound =1000000;
        }
        else if(type.equals("7")){
            typeText = "1,000,001-2,000,000 บาท\nขั้นบันได 25%";
            taxRateS = "25%";
            taxRate = 25.0/100.0;
            additional = 11500;
            lowerBound = 1000001;
            upperBound =2000000;
            limitMoney=1000000;
        }
        else if(type.equals("8")){
            typeText = "2,000,001-5,000,000 บาท\nขั้นบันได 30%";
            taxRateS = "30%";
            taxRate = 30.0/100.0;
            additional = 365000;
            lowerBound = 2000001;
            upperBound =5000000;
            limitMoney=2000000;
        }
        else if(type.equals("9")){
            typeText = "มากกว่า 5,000,000 บาท\nขั้นบันได 35%";
            taxRateS = "35%";
            taxRate = 35.0/100.0;
            lowerBound = 50000001;
            upperBound =-1;
            additional = 1265000;
            limitMoney=5000000;
        }
//        bottomNavigationView.setSelectedItemId(R.id.progressive_tax);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculate_tax, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            type=  bundle.getString("type");
        }
        lightenEt = view.findViewById(R.id.lighten);
        revenueEt = view.findViewById(R.id.revenue);
        expensesEt =view.findViewById(R.id.expenses);
        Button btn = view.findViewById(R.id.calculateButton);
        TextView tvDisplay = view.findViewById(R.id.tvDisplay);
        setup();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lightenSt = lightenEt.getText().toString()==null|| lightenEt.getText().toString().equals("")?"0":lightenEt.getText().toString();
                String revenueSt = revenueEt.getText().toString()==null||revenueEt.getText().toString().equals("")?"0":revenueEt.getText().toString();
                String expensesSt = expensesEt.getText().toString()==null||expensesEt.getText().toString().equals("")?"0":expensesEt.getText().toString();
                double lighten =  Double.valueOf(lightenSt);
                double revenue = Double.valueOf(revenueSt);
                double expenses = Double.valueOf(expensesSt);
                if (upperBound == -1){
                    if(!(revenue>lowerBound)){
                        Toast.makeText(getContext().getApplicationContext(), "กรุณากรอกจำนวนรายรับตั้งเเต่ "+lowerBound+" บาทเป็นต้นไป", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                else{
                    if(!(revenue>=lowerBound && revenue<=upperBound)){
                        Toast.makeText(getContext().getApplicationContext(), "กรุณากรอกจำนวนรายรับ "+lowerBound+" - " +upperBound+" บาท", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                totalMoney = revenue - lighten - expenses;
                if(type.equals("1")){
                    totalTax = calculateTaxFlatPayment();
                }
                else{
                    totalTax = calculateTax();
                }
                Log.d("test" , String.valueOf(totalTax));
                openResultPage(lighten,revenue,expenses);
            }
        });
        tvDisplay.setText(typeText);
        return view;
    }
    private void openResultPage(double lighten,double revenue,double expenses){
        FragmentTransaction transaction =  getActivity().getSupportFragmentManager().beginTransaction();
        ResultTax resultTax = new ResultTax();
        Bundle bundle = new Bundle();
        bundle.putString("tax", String.valueOf(totalTax));
        bundle.putString("taxRate", taxRateS);
        bundle.putString("lighten", String.valueOf(lighten));
        bundle.putString("revenue", String.valueOf(revenue));
        bundle.putString("expenses", String.valueOf(expenses));
        bundle.putString("total", String.valueOf(totalMoney));
        bundle.putString("type", typeText);
        resultTax.setArguments(bundle);
        transaction.replace(R.id.mainDisplay, resultTax);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}