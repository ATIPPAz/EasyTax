package com.example.easytax.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.easytax.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultTax#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultTax extends Fragment {
double  tax ,lighten,revenue,expenses,total;
String taxRate,type;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ResultTax() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResultTax.
     */
    // TODO: Rename and change types and number of parameters
    public static ResultTax newInstance(String param1, String param2) {
        ResultTax fragment = new ResultTax();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result_tax, container, false);
        TextView taxTv =view.findViewById(R.id.tax);
        TextView taxRateTv = view.findViewById(R.id.taxRate);
        TextView lightenTv =view.findViewById(R.id.lighten);
        TextView revenueTv = view.findViewById(R.id.revenue);
        TextView expensesTv =  view.findViewById(R.id.expenses);
        TextView typeTv  =  view.findViewById(R.id.type);
        TextView usernameTv =  view.findViewById(R.id.username);
        TextView totalTv =  view.findViewById(R.id.total);
        Bundle bundle = getArguments();
        if (bundle != null) {
            tax = Double.valueOf(bundle.getString("tax").toString());
            taxRate =  bundle.getString("taxRate").toString();
            lighten = Double.valueOf(bundle.getString("lighten").toString());
            revenue = Double.valueOf(bundle.getString("revenue").toString());
            expenses =  Double.valueOf(bundle.getString("expenses").toString());
            type  =  bundle.getString("type").toString();
            total =  Double.valueOf(bundle.getString("total").toString());
        }
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("EasyTax", Context.MODE_PRIVATE);
        usernameTv.setText(sharedPreferences.getString("username", null));
         taxTv.setText(String.valueOf(tax) + " บาท");
         taxRateTv.setText(String.valueOf(taxRate) );
         lightenTv.setText(String.valueOf(lighten) + " บาท");
         revenueTv.setText(String.valueOf(revenue)+ " บาท" ) ;
         expensesTv.setText(String.valueOf(expenses) + " บาท");
         typeTv.setText(String.valueOf(type));
         totalTv.setText(String.valueOf(total) + " บาท");
        return view;
    }
}