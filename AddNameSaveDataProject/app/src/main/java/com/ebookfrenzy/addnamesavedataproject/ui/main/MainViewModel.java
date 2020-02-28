package com.ebookfrenzy.addnamesavedataproject.ui.main;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    ArrayList<String> listNames = new ArrayList<String>();
    //ArrayAdapter<String> adapter;
    //private String nameText = "";

    //public ArrayList<String> getNames(){
//        return listNames;
//    }

    public ArrayList<String> addNames(String name) {
        //grab name from edit text box
        //this.nameText = name;
        listNames.add(name);
        return listNames;
    }
}
