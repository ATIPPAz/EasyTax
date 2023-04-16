package com.example.easytax;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easytax.fragments.CalculateTax;
import com.example.easytax.fragments.Home;
import com.example.easytax.fragments.Profile;
import com.example.easytax.fragments.ProgressiveTax;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
String name = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences("EasyTax", Context.MODE_PRIVATE);
        BottomNavigationView btMenu = findViewById(R.id.btMenu);
        if(!sharedPreferences.contains("username")){
            name = sharedPreferences.getString("username", null);
            if (name != null){
                replaceFragment(new Home());
            }
            else{
                Intent intent = new Intent(MainActivity.this, GetUserNameActivity.class);
                startActivity(intent);
                Log.d("test",intent.toString());
                finish();
                Toast.makeText(getApplicationContext(), "Please Enter your username", Toast.LENGTH_SHORT).show();

//                replaceFragment(new GetUserName());
            }
        }
        else{
            name = sharedPreferences.getString("username", null);
            replaceFragment(new Home());
        }
        TextView userShow = findViewById(R.id.usernameShow);
        userShow.setText(name);
        btMenu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        replaceFragment(new Home());
                        break;
                    case R.id.flat_tax:
                        CalculateTax cal  =  new CalculateTax();
                        Bundle bundle = new Bundle();
                        bundle.putString("type", "1");
                        cal.setArguments(bundle);
                        replaceFragment(cal);
                        break;
                    case R.id.progressive_tax:
                        replaceFragment(new ProgressiveTax());
                        break;
                    case R.id.profile:
                        replaceFragment(new Profile());
                        break;
                }
                return true;
            }
        });

    }
    private void replaceFragment(Fragment fragment){
        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.mainDisplay, fragment);
            fragmentTransaction.commit();
        }
    }
}