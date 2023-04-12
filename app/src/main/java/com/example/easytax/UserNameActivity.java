package com.example.easytax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_name);
    }
    public void goToSelecterPage(View view){
        EditText editTextUsername = findViewById(R.id.usernameTv);
        String username = editTextUsername.getText().toString();
        if (username != null && !username.isEmpty() && !username.equals("")) {
            Intent intent = new Intent(UserNameActivity.this,SelectorActivity.class);
            SharedPreferences sharedPreferences = getSharedPreferences("EasyTax", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", username);
            editor.apply();
            startActivity(intent);
            finish();
        } else {

            Toast.makeText(getApplicationContext(), "Please Enter your username", Toast.LENGTH_SHORT).show();
        }

    }
}