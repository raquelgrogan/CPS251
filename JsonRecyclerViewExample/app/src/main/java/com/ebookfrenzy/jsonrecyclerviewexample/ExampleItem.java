package com.ebookfrenzy.jsonrecyclerviewexample;

public class ExampleItem {
    private String imageURL;
    private String mName;
    private String desc;
    private int phone;

    public ExampleItem(String imageURL, String mName, String desc, int phone) {
        this.imageURL = imageURL;
        this.mName = mName;
        this.desc = desc;
        this.phone = phone;
    }

    public String getImageURL(){
        return imageURL;
    }

    public String getmName() {
        return mName;
    }

    public String getDesc() {
        return desc;
    }
    public int getPhone() {
        return phone;
    }
}
