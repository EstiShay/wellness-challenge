package com.epicodus.wellnesschallenge.models;

import org.parceler.Parcel;

@Parcel
public class Exercise {
    String date;
    String exerciseType;
    double miles;
    private String pushId;

    public Exercise(){}

    public Exercise(String date, String exerciseType, double miles){
        this.date = date;
        this.exerciseType = exerciseType;
        this.miles = miles;
    }

    public String getDate(){
        return date;
    }
    public String getExerciseType(){
        return exerciseType;
    }
    public double getMiles(){
        return miles;
    }
    public String getPushId(){
        return pushId;
    }
    public void setPushId(String pushId){
        this.pushId = pushId;
    }
}
