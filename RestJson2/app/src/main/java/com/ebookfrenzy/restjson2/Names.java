package com.ebookfrenzy.restjson2;

import java.util.ArrayList;

public class Names {

    private String age;
    private String eyeColor;
    private String name;
    private String gender;
    private String company;
    private String email;
    private String phone;
    private String address;

    //THIS IS AN ARRAY LIST THAT CONTAINS ALL THE CARD DATA
    private ArrayList<Names> names;

    public ArrayList<Names> getNamesList() {
        return names;
    }

    //METHODS FOR GETTING EACH COUPON


    public String getAge() {
        return age;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
