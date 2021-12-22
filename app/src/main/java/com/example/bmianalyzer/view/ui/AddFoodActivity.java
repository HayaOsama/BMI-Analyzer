package com.example.bmianalyzer.view.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import com.example.bmianalyzer.R;
import com.example.bmianalyzer.databinding.ActivityAddFoodBinding;

public class AddFoodActivity extends AppCompatActivity {
private ActivityAddFoodBinding binding ;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        binding.foodCat.setAdapter(new ArrayAdapter<String>(this ,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.food_category)));
    }
}