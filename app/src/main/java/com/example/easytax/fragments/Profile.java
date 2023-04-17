package com.example.easytax.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easytax.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    Button saveBtn = null;
    SharedPreferences sharedPreferences =  null;

    Button cancelBtn = null;
    EditText username= null;
    EditText lastname= null;
    EditText age= null;
    EditText occupation= null;
    EditText salary = null;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Profile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Profile.
     */
    // TODO: Rename and change types and number of parameters
    public static Profile newInstance(String param1, String param2) {
        Profile fragment = new Profile();
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
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
         saveBtn = view.findViewById(R.id.saveBtn);
         cancelBtn = view.findViewById(R.id.cancelBtn);
         username= view.findViewById(R.id.editUsername);
         lastname= view.findViewById(R.id.editLastname);
         age= view.findViewById(R.id.editAge);
         occupation= view.findViewById(R.id.editOccupation);
         salary = view.findViewById(R.id.editSalary);
        sharedPreferences = getActivity().getSharedPreferences("EasyTax", Context.MODE_PRIVATE);
         if(sharedPreferences.contains("username")){
             username.setText(sharedPreferences.getString("username", null));
         }
        if(sharedPreferences.contains("lastname")){
            lastname.setText(sharedPreferences.getString("lastname", null));
        }
        if(sharedPreferences.contains("age")){
            age.setText(sharedPreferences.getString("age", null));
        }
        if(sharedPreferences.contains("occupation")){
            occupation.setText(sharedPreferences.getString("occupation", null));
        }
        if(sharedPreferences.contains("salary")){
            salary.setText(sharedPreferences.getString("salary", null));
        }

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameS = username.getText().toString();
                String lastnameS = lastname.getText().toString();
                String ageS = age.getText().toString();
                String occupationS = occupation.getText().toString();
                String salaryS = salary.getText().toString();
                if(usernameS.equals("") || usernameS == null){
                    Toast.makeText(getContext().getApplicationContext(), "กรุณากรอกชื่อ", Toast.LENGTH_SHORT).show();
                    return;
                }
                try{
                    if(ageS.length()>0){
                        Integer.parseInt(ageS);
                    }
                }
                catch (NumberFormatException ex){
                    ex.printStackTrace();
                    Toast.makeText(getContext().getApplicationContext(), "กรุณากรอกอายุเป็นตัวเลข", Toast.LENGTH_SHORT).show();
                    return;
                }
                try{
                    if(salaryS.length()>0){
                        Integer.parseInt(salaryS);
                    }
                }
                catch (NumberFormatException ex){
                    ex.printStackTrace();
                    Toast.makeText(getContext().getApplicationContext(), "กรุณากรอกเงินเดือนเป็นตัวเลข", Toast.LENGTH_SHORT).show();
                    return;
                }
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", usernameS);
                editor.putString("lastname", lastnameS);
                editor.putString("age", ageS);
                editor.putString("occupation", occupationS);
                editor.putString("salary", salaryS);
                editor.apply();
                Toast.makeText(getContext().getApplicationContext(), "บันทึกสำเร็จ", Toast.LENGTH_SHORT).show();

                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.btMenu);
                bottomNavigationView.setSelectedItemId(R.id.home);
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.btMenu);
                bottomNavigationView.setSelectedItemId(R.id.home);
            }
        });

        return view;
    }
}