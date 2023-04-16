package com.example.easytax.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.easytax.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProgressiveTax#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProgressiveTax extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProgressiveTax() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProgressiveTax.
     */
    // TODO: Rename and change types and number of parameters
    public static ProgressiveTax newInstance(String param1, String param2) {
        ProgressiveTax fragment = new ProgressiveTax();
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
        View view  = inflater.inflate(R.layout.fragment_progressive_tax, container, false);
        TextView btn1 = view.findViewById(R.id.tvBtn);
        FragmentTransaction transaction =  getActivity().getSupportFragmentManager().beginTransaction();
        CalculateTax calculateTaxFragment = new CalculateTax();
        Bundle bundle = new Bundle();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("type", "2");
                calculateTaxFragment.setArguments(bundle);
                transaction.replace(R.id.mainDisplay, calculateTaxFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        TextView btn2 = view.findViewById(R.id.tvBtn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("type", "3");
                calculateTaxFragment.setArguments(bundle);
                transaction.replace(R.id.mainDisplay, calculateTaxFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        TextView btn3 = view.findViewById(R.id.tvBtn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("type", "4");
                calculateTaxFragment.setArguments(bundle);
                transaction.replace(R.id.mainDisplay, calculateTaxFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        TextView btn4 = view.findViewById(R.id.tvBtn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("type", "5");
                calculateTaxFragment.setArguments(bundle);
                transaction.replace(R.id.mainDisplay, calculateTaxFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        TextView btn5 = view.findViewById(R.id.tvBtn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("type", "6");
                calculateTaxFragment.setArguments(bundle);
                transaction.replace(R.id.mainDisplay, calculateTaxFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        TextView btn6 = view.findViewById(R.id.tvBtn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("type", "7");
                calculateTaxFragment.setArguments(bundle);
                transaction.replace(R.id.mainDisplay, calculateTaxFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        TextView btn7 = view.findViewById(R.id.tvBtn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("type", "8");
                calculateTaxFragment.setArguments(bundle);
                transaction.replace(R.id.mainDisplay, calculateTaxFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        TextView btn8 = view.findViewById(R.id.tvBtn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("type", "9");
                calculateTaxFragment.setArguments(bundle);
                transaction.replace(R.id.mainDisplay, calculateTaxFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;

    }
}