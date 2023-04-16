package com.example.easytax.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.easytax.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalculateTax#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculateTax extends Fragment {
    String type = "1";

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
    private void calculateTax(){
        totalTax = ((totalMoney-limitMoney)*taxRate)+additional;
    }
    private void calculateTaxFlatPayment(){
        totalTax = ((totalMoney-limitMoney)*taxRate)+additional;
    }
    public void setup(){
//        BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.btMenu);

        if(type.equals("1")){
            typeText = "แบบเหมาจ่าย";
//            bottomNavigationView.setSelectedItemId(R.id.flat_tax);
            return;
        }
        else if(type.equals("2")){
            typeText = "ไม่เกิน 150,000 บาท ขั้นบันได 0%";
            taxRate = 0;
            additional = 0;
            limitMoney= 0;
        }
        else if(type.equals("3")){
            typeText = "150,001-300,000 ขั้นบันได 5%บาท";
            taxRate = 5/100;
            additional = 0;
            limitMoney= 150000;
        }
        else if(type.equals("4")){
            typeText = "300,001-500,000 ขั้นบันได 10%บาท";
            taxRate = 10/100;
            additional = 7500;
            limitMoney= 300000;
        }
        else if(type.equals("5")){
            typeText = "500,001-750,000 ขั้นบันได 15%บาท";
            taxRate = 15/100;
            additional = 27500;
            limitMoney= 500000;
        }
        else if(type.equals("6")){
            typeText = "750001-1,000,000 ขั้นบันได 20%บาท";
            taxRate = 20/100;
            additional = 65000;
            limitMoney= 750000;
        }
        else if(type.equals("7")){
            typeText = "1,000,001-2,000,000 ขั้นบันได 25%บาท";
            taxRate = 25/100;
            additional = 11500;
            limitMoney=1000000;
        }
        else if(type.equals("8")){
            typeText = "2,000,001-5,000,000 ขั้นบันได 30%บาท";
            taxRate = 30/100;
            additional = 365000;
            limitMoney=2000000;
        }
        else if(type.equals("9")){
            typeText = "มากกว่า 5,000,000 ขั้นบันได 35%บาท";
            taxRate = 35/100;
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
            Log.d("test",type );
        }
        Button btn = view.findViewById(R.id.calculateButton);
        TextView tvDisplay = view.findViewById(R.id.tvDisplay);
        setup();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(type=="1"){
                    calculateTaxFlatPayment();
                }
                else{
                    calculateTax();
                }
            }
        });
        tvDisplay.setText(typeText);
        return view;
    }
}