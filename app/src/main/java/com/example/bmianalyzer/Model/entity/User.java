package com.example.bmianalyzer.Model.entity;

import com.example.bmianalyzer.R;

import static com.example.bmianalyzer.Model.Interfaces.BMIConstants.*;
import java.util.ArrayList;

public class User {

   private String name , password , email ;
   private double  age ;
   private ArrayList<BMIRecord> records  ;
   private static  User user ;
   private int gender ;

  public static final User getUser(String name, String password, String email , int gender){
      if (user == null) user= new User(name , password , email , gender);
      return user ;
  }

    private User(String name, String password, String email, int gender) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.gender = gender ;
        records = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public ArrayList<BMIRecord> getRecords() {
        return records;
    }

    public void addRecord(BMIRecord record) {
         records.add(record);
    }

    public void reset(){
      records = new ArrayList<>();
    }
    public BMIRecord getRecord(int record) {
        return records.get(record);
    }

    public void setRecords(ArrayList<BMIRecord> records) {
        this.records = records;
    }

    public double getAgePercentage(){
      if ( age >=2 && age<= 10) return .7 ;
        if ( age >10 && age<= 20)
         switch (gender){
          case MALE :
              return 0.9;
          case FEMALE :
              return  0.8 ;
         }
      return 1 ;
    }

    public int getStatus(){
      return BMIRecord.toStringStatus(records.get(records.size()-1).getStatus(getAgePercentage()));
    }

    public int getMessage(){
      int i = records.size()-1 ;
      return getMessage(records.get(i) , records.get(i-1));
    }
    public int getMessage(BMIRecord rc1 , BMIRecord rc2){
       double diff = rc1.getBMI(getAgePercentage()) - rc2.getBMI(getAgePercentage()) ;
       int status= rc1.getStatus(getAgePercentage());
        switch (status){
            case UNDER_WEIGHT :
                if(diff < -1 || (diff >= -1 && diff < -0.3)) return R.string.SB ;
                else if (diff>= -0.3 && diff< 0.3) return R.string.LC ;
                else if (diff>= 0.3 && diff< 0.6) return R.string.SG ;
                else return R.string.GA ;
            case NORMAL :
                if(diff < -1 ) return R.string.SB ;
                else if (diff>= -1 && diff< -0.3) return R.string.BC ;
                else if (diff>= -0.3 && diff< 0.3) return R.string.LC ;
                else return R.string.BC ;
            case OVER_WEIGHT :
                if(diff < -1 ) return R.string.BC ;
                else if (diff >= -1 && diff < -0.6) return R.string.GA ;
                else if (diff>= -0.6 && diff< -0.3) return R.string.SG ;
                else if (diff>= -0.3 && diff< 0.3) return R.string.LC ;
                else if (diff>= 0.3 && diff< 0.6) return R.string.BC ;
                else return R.string.SB ;
            case OBESITY :
                if(diff < -1 || (diff >= -1 && diff < -0.3)) return R.string.GA ;
                else if (diff>= -0.6 && diff< 0) return R.string.LC ;
                else if (diff>= 0 && diff< 0.3) return R.string.BC ;
                else return R.string.SB ;
        }

        return R.string.SG ;
    }
}
