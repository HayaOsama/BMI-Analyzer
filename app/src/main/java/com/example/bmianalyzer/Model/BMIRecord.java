package com.example.bmianalyzer.Model;

import com.example.bmianalyzer.R;

import java.util.Date;

import static com.example.bmianalyzer.Model.BMIConstants.*;

public class BMIRecord {
   private double length , weight ;
   private Date date ;

    public BMIRecord(double length, double weight, Date date) {
        this.length = length;
        this.weight = weight;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public double getBMI(double percent) {
        return (weight / Math.sqrt(length) ) * percent ;

    }

    public int getStatus(double percent) {
        double bmi = getBMI(percent);
        if(bmi < 18.5 ) return UNDER_WEIGHT;
        if(bmi >= 18.5 && bmi < 25  ) return NORMAL;
        if(bmi >= 25 && bmi < 30 ) return OVER_WEIGHT;
        return OBESITY;
    }

    public static int toStringStatus(int status) {
        switch(status){
            case NORMAL : return  R.string.normal ;
            case OBESITY : return R.string.obesity ;
            case OVER_WEIGHT : return R.string.over_weight;
            case UNDER_WEIGHT : return R.string.under_weight;
        }
        return -1;
    }




}
