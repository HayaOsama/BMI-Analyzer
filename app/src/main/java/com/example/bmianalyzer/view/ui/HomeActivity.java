package com.example.bmianalyzer.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.bmianalyzer.Model.Interfaces.BMIConstants;
import com.example.bmianalyzer.Model.entity.BMIRecord;
import com.example.bmianalyzer.Model.entity.User;
import com.example.bmianalyzer.R;
import com.example.bmianalyzer.databinding.ActivityHomeBinding;
import com.example.bmianalyzer.view.adapter.BMIRecordAdapter;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding ;
    private static User user;
    private BMIRecordAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        storeData();
        adapter = new BMIRecordAdapter(user , getBaseContext());
        binding.name.setText(user.getName());
        binding.currentStatus.setText(user.getStatus());
        binding.message.setText(user.getMessage());
        adapter.setRecords(user.getRecords());
        binding.recyclerView.setAdapter(adapter);

        Toast.makeText(this, "Count = "+adapter.getItemCount(), Toast.LENGTH_SHORT).show();
        }

    void storeData(){
        user = User.getUser("Haya","123", "haya@gmail.com", BMIConstants.FEMALE);
        for(int i=0 ; i<=10 ; i++){
            user.addRecord(new BMIRecord(161 , 60+i , ""+ 10+i +"/" + 2+i + "/2021"));
        }
    }
}