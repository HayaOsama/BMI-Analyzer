package com.example.bmianalyzer.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bmianalyzer.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {
   private  ActivitySplashBinding binding ;
   private Intent intent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intent = new Intent(this , HomeActivity.class);

    }//onCreate


    public void next(View view) {
        finish();
        startActivity(intent);

    }//next

}//SplashActivity