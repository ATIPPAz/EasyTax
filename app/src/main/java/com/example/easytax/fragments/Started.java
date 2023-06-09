package com.example.easytax.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.easytax.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Started#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Started extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Started() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Started.
     */
    // TODO: Rename and change types and number of parameters
    public static Started newInstance(String param1, String param2) {
        Started fragment = new Started();
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
    private void replaceFragment(Fragment fragment){
        if(fragment != null){
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.mainDisplay, fragment);
            fragmentTransaction.commit();
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_started, container, false);
        Button btprogressive = view.findViewById(R.id.button3);
        Button btflat = view.findViewById(R.id.button4);
        btprogressive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressiveTax progressiveTax  =  new ProgressiveTax();
                replaceFragment(progressiveTax);
                replaceFragment(new Home());
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.btMenu);
                bottomNavigationView.setSelectedItemId(R.id.progressive_tax);
            }
        });
        btflat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculateTax cal  =  new CalculateTax();
                Bundle bundle = new Bundle();
                bundle.putString("type", "1");
                cal.setArguments(bundle);
                replaceFragment(cal);
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.btMenu);
                bottomNavigationView.setSelectedItemId(R.id.flat_tax);
            }
        });
        return view;
    }
}