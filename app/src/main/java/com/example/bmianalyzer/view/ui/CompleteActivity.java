package com.example.bmianalyzer.view.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;

import android.content.Intent;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.example.bmianalyzer.Model.Interfaces.BMIConstants;
import com.example.bmianalyzer.Model.storageHelpers.SharedPreferencesHelper;
import com.example.bmianalyzer.Model.entity.BMIRecord;
import com.example.bmianalyzer.Model.entity.User;
import com.example.bmianalyzer.R;
import com.example.bmianalyzer.databinding.ActivityCompleteBinding;
import com.example.bmianalyzer.view.Pickers.DatePickerFragment;

import java.util.Calendar;
import java.util.Date;

public class CompleteActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener  {
    private ActivityCompleteBinding binding;
    private User user;
    private int length = 160 , weight = 60 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCompleteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        //attach onClickListeners
        binding.minusLength.setOnClickListener(this);
        binding.plusLength.setOnClickListener(this);
        binding.minusWeight.setOnClickListener(this);
        binding.plusWeight.setOnClickListener(this);
        binding.dobEdit.setOnClickListener(this);
        binding.saveDataBtn.setOnClickListener(this);
        user =SharedPreferencesHelper.getUser(getApplicationContext());

    }


    //onClickListener
    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.minus_length:
                length--;
                binding.length.setText(String.format("%d", length));
                return;
            case R.id.minus_weight:
                weight--;
                binding.weightTxt.setText(String.format("%d", weight));
                return;
            case R.id.plus_length:
                length++;
                binding.length.setText(String.format("%d", length));
                return;
            case R.id.plus_weight:
                weight++;
                binding.weightTxt.setText(String.format("%d", weight));
                return;
            case R.id.edit_date:
                showDatePickerDialog();
                return;

            case R.id.save_data_btn:
                storeUserInfo();
                return;
            default:

        }//switch
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void storeUserInfo() {
        //todo: save the info in firebase
        if(binding.maleRd.isChecked())user.setGender(BMIConstants.MALE);
        else user.setGender(BMIConstants.FEMALE);
        String date = Calendar.DAY_OF_MONTH+"/"+ Calendar.MONTH+"/"+Calendar.YEAR ;
        user.addRecord(new BMIRecord(length , weight ,date));
        SharedPreferencesHelper.setUser(user,getApplicationContext());
        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        String date = "" + i2 + "/" + i1 + "/" + i;
        binding.dobEdit.setText(date);
        user.setBod(new Date(i,i1,i2));
    }

    private void showDatePickerDialog() {
        DialogFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.setShowsDialog(true);
        datePickerFragment.show(getSupportFragmentManager(), BMIConstants.DATE_PICKER);
    }
}