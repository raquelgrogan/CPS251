package com.ebookfrenzy.recyclercardasync;


import java.util.ArrayList;

public class NameData {
    ArrayList<String> names = new ArrayList();

    public ArrayList<String> getNames(){
        return names;
    }
    public void clearNames(){
        names.clear();
    }
}
