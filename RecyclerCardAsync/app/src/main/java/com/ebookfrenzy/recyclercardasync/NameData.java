package com.ebookfrenzy.recyclercardasync;


import android.util.Log;

import java.util.ArrayList;

public class NameData {
    private ArrayList<String> names = new ArrayList();
    private final String TAG = "ErrorTag";

    public void addName(String newName){
        names.add(newName);
        //error checking
        if(!names.isEmpty()) {
            Log.i(TAG, "The content of the array are NOT empty");
            for (int i=0; i < names.size();i++){
                Log.i(TAG,"Values of the array are: "+names.get(i));
            }
        }else{Log.i(TAG, "The content of the array ARE empty");}
    }

    public ArrayList<String> getNames(){
        return names;
    }
    public void clearNames(){
        names.clear();
    }
}
