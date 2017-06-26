package com.mastek.anew.welcome;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Nishant11960 on 30/05/2017.
 */

public class UserLocalStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userSharedPreferences;

    public UserLocalStore(Context context) {
        this.userSharedPreferences = context.getSharedPreferences("SP_NAME",0);
    }

    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userSharedPreferences.edit();
        spEditor.putString("name",user.name);
        spEditor.putInt("age",user.age);
        spEditor.putString("username",user.username);
        spEditor.putString("password",user.password);
        spEditor.commit();
    }

    public User getLoggedInUser(){

        String name = userSharedPreferences.getString("name","");
        int age = userSharedPreferences.getInt("age",-1);
        String username = userSharedPreferences.getString("username","");
        String password = userSharedPreferences.getString("password","");

        User storedUser = new User(name,username,password,age);
        return storedUser;
    }

    public void setUserLoggedIN(boolean loggedIN){
        SharedPreferences.Editor spEditor = userSharedPreferences.edit();
        spEditor.putBoolean("loggedIN",loggedIN);
        spEditor.commit();
    }

    public boolean getUserLoggedIN(){
        if(userSharedPreferences.getBoolean("loggedIN",false)==true){
            return true;
        }else {
            return false;
        }
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userSharedPreferences.edit();
        spEditor.clear();
        spEditor.commit();
    }

    public boolean authenticate(User user){
        if (null!=user){
            return false;
        }

        String username = userSharedPreferences.getString("username","").toString();

        String password = userSharedPreferences.getString("password","").toString();

        if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

}
