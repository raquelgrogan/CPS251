package com.ebookfrenzy.classexample3.ui.main;

import android.widget.EditText;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public String newText = "";

    public void pressText(){
        //newText.set
    }

    public String getNewText()
    {
        return newText;
    }
}
