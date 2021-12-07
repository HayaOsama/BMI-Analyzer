package com.example.bmianalyzer.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bmianalyzer.Model.User;
import com.example.bmianalyzer.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
private ActivityLoginBinding binding ;
private User user ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

    private boolean check(String user, String password){
        return true ;
    }
}