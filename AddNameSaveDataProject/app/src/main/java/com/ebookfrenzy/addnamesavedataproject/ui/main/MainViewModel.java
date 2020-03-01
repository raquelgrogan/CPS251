package com.ebookfrenzy.addnamesavedataproject.ui.main;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    ArrayList<String> listNames = new ArrayList<String>();
    public ArrayList<String> getNames(){
        //access names from mViewModel
        return listNames;
    }

    public void addNames(String name) {
        //add name to array in MainViewModel
        listNames.add(name);
    }
}
