package com.ebookfrenzy.recyclercardasync;


import android.util.Log;

import java.util.ArrayList;

public class NameData {
    public static ArrayList<String> names = new ArrayList<>();
    public static ArrayList<String> times = new ArrayList<>();
    private static final String TAG = "ErrorTag";

//    public static void addName(String newName){
//        names.add(newName);
//        //error checking
//        if(!names.isEmpty()) {
//            Log.i(TAG, "The content of the array is NOT empty");
//            for (int i=0; i < names.size();i++){
//                Log.i(TAG,"Values of the array are: "+names.get(i));
//            }
//        }else{Log.i(TAG, "The content of the array ARE empty");}
//    }

    public static ArrayList<String> getNamesArr(){
        return names;
    }
    public static String getName(int i){
        return names.get(i);
    }
    public static ArrayList<String> getTimesArr(){
        return times;
    }
    public static String getTime(int i){
        return times.get(i);
    }
    public static void clear(){
        times.clear();
        names.clear();
    }

}
