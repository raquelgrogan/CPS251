package com.ebookfrenzy.restjson;

import java.util.ArrayList;

public class PersonArray {
    private ArrayList<PersonArray> names;

    public PersonArray(ArrayList<PersonArray> names, int age, String eyeColor, String name, String gender, String company, String email, String phone, String address) {
        this.names = names;
        this.age = age;
        this.eyeColor = eyeColor;
        this.name = name;
        this.gender = gender;
        this.company = company;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public ArrayList<PersonArray> getPersonArray(){
        return names;
    }

    private int age;
    private String eyeColor,name,gender,company,email, phone,address;


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getCompany() {
        return company;
    }

    public int getAge() {
        return age;
    }
    public String getGender(){
        return gender;
    }
}
