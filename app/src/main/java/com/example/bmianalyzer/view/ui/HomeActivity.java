package com.example.bmianalyzer.view.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;



import com.example.bmianalyzer.Model.storageHelpers.SharedPreferencesHelper;
import com.example.bmianalyzer.Model.entity.BMIRecord;
import com.example.bmianalyzer.Model.entity.User;
import com.example.bmianalyzer.R;
import com.example.bmianalyzer.databinding.ActivityHomeBinding;
import com.example.bmianalyzer.view.adapter.BMIRecordAdapter;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityHomeBinding binding ;
    private static User user;
    private BMIRecordAdapter adapter ;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        storeData();
        //set the onClickListener
        binding.addFoodButton.setOnClickListener(this);
        binding.addRecordButton.setOnClickListener(this);
        binding.logout.setOnClickListener(this);

        adapter = new BMIRecordAdapter(user , getBaseContext());
        binding.name.setText(user.getName());
        binding.currentStatus.setText(user.getStatus());
        binding.message.setText(user.getMessage());
        adapter.setRecords(user.getRecords());

        binding.recyclerView.setAdapter(adapter);


     //   Toast.makeText(this, "AGE = "+user.getAge(), Toast.LENGTH_SHORT).show();
        }

    void storeData(){
        user = SharedPreferencesHelper.getUser(getApplicationContext());
        if(user!=null)
        for(int i=0 ; i<=10 ; i++){
            user.addRecord(new BMIRecord(161 , (50+i) , ""+ (10+i) +"/" + (2+i) + "/2021"));
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent ;
        switch (view.getId()){
            case R.id.add_food_button:
             intent = new Intent(HomeActivity.this, AddFoodActivity.class );
             break;
            case R.id.add_record_button:
                intent = new Intent(HomeActivity.this, NewRecordActivity.class );
                break;
            case R.id.logout:
                intent = new Intent(HomeActivity.this, LoginActivity.class );
                SharedPreferencesHelper.clearUser(getApplicationContext());
                break;
            default:
                intent = new Intent(HomeActivity.this, SplashActivity.class);
        }
        startActivity(intent);
    }
}