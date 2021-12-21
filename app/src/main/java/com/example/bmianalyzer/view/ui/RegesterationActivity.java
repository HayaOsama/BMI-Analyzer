package com.example.bmianalyzer.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bmianalyzer.Model.Interfaces.BMIConstants;
import com.example.bmianalyzer.R;
import com.example.bmianalyzer.databinding.ActivityRegesterationBinding;

public class RegesterationActivity extends AppCompatActivity  {
private ActivityRegesterationBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegesterationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        clicks();
    }

    private void clicks() {
        binding.createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(register()){
                    finish();
                    startActivity(new Intent(RegesterationActivity.this , CompleteActivity.class));
                }else {
                    Toast.makeText(RegesterationActivity.this, "The.....", Toast.LENGTH_SHORT).show();
                }

            }
        });

        binding.loginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegesterationActivity.this , LoginActivity.class));
            }
        });
    }

    private boolean register(){
        //todo: firebase code
        String userName= binding.name.getText().toString();
        String userPassword= binding.password.getText().toString();
        String userRePassword= binding.repassword.getText().toString();

        if(userPassword.equals(userRePassword)){
            SharedPreferences.Editor sharedPref = getPreferences(Context.MODE_PRIVATE).edit();
            sharedPref.putBoolean(BMIConstants.USER_LOGIN_STATUS, true);
            sharedPref.putString(BMIConstants.USER_NAME, userName);
            sharedPref.putString(BMIConstants.USER_PASSWORD, userPassword);
            sharedPref.apply();
            return true ;
        }else{
            Toast.makeText(this, "Password and re-password are not matched", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
}