package com.example.bmianalyzer.Model;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.bmianalyzer.Model.Interfaces.BMIConstants;

public class SharedPreferencesHelper {
    public static boolean isLoggedIn(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(BMIConstants.USER_LOGIN_STATUS, Context.MODE_PRIVATE);
        return preferences.getBoolean(BMIConstants.USER_LOGIN_STATUS, false);
    }

    public static int getUserGender(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(BMIConstants.USER_GENDER, Context.MODE_PRIVATE);
        return preferences.getInt(BMIConstants.USER_GENDER, -1);
    }

    public static int getUserStatus(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(BMIConstants.USER_STATUS, Context.MODE_PRIVATE);
        return preferences.getInt(BMIConstants.USER_STATUS, -1);
    }

    public static int getUserMessage(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(BMIConstants.USER_MESSAGE, Context.MODE_PRIVATE);
        return preferences.getInt(BMIConstants.USER_MESSAGE, -1);
    }

    public static String getUserName(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(BMIConstants.USER_NAME, Context.MODE_PRIVATE);
        return preferences.getString(BMIConstants.USER_NAME, "Empty");
    }


    public static String getUserPassword(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(BMIConstants.USER_PASSWORD, Context.MODE_PRIVATE);
        return preferences.getString(BMIConstants.USER_PASSWORD, "Empty");
    }
}
