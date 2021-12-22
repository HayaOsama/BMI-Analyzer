package com.example.bmianalyzer.Model.storageHelpers;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.bmianalyzer.Model.entity.BMIRecord;
import com.example.bmianalyzer.Model.entity.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseHelper {
    private static FirebaseHelper firebaseHelper ;

    public static FirebaseHelper getInstance(){
        if(firebaseHelper==null) firebaseHelper=new FirebaseHelper();
        return firebaseHelper ;
    }

    private FirebaseHelper(){

    }

    public void addBMIRecord(BMIRecord record){

    }

    public void createUser(User user , Context context){
      FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
      firebaseAuth.createUserWithEmailAndPassword(user.getEmail(),user.getPassword())
              .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful()){
                          createUser(user);
                      }else{
                          Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show();
                      }
                  }
              });
    }


    public void createUser(User user){

    }

    public void completeRegistration(User user){

    }

    public User login(String name, String password){
        User user = User.getUser(name,password) ;
        return user;
    }


}

