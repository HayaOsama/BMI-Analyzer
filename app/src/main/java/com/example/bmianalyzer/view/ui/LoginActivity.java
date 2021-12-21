package com.example.bmianalyzer.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bmianalyzer.Model.Interfaces.BMIConstants;
import com.example.bmianalyzer.Model.entity.User;
import com.example.bmianalyzer.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
private ActivityLoginBinding binding ;
private User user ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        clicks();




    }

    private boolean check(String username, String password){
        //todo: check at the firebase
        if(username.equals("haya")&&password.equals("123")){
            user = User.getUser(username,password);
            SharedPreferences.Editor sharedPref = getPreferences(Context.MODE_PRIVATE).edit();
            sharedPref.putBoolean(BMIConstants.USER_LOGIN_STATUS, true);
            sharedPref.putString(BMIConstants.USER_NAME, user.getName());
            sharedPref.putString(BMIConstants.USER_PASSWORD, user.getPassword());
            sharedPref.apply();
            return true ;
        }
       return false ;
    }


    private void clicks(){
        binding.signUpTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             startActivity(new Intent(LoginActivity.this,RegesterationActivity.class));
            }
        });

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check(binding.userName.getText().toString(),binding.password.getText().toString())){
                    finish();
                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this, "User Name or Password are wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}