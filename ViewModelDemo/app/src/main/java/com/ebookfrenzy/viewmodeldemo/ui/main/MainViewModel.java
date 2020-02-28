package com.ebookfrenzy.viewmodeldemo.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private static final Float usd_to_eu_rate = 0.74F;
    //private String dollarText = "";
    public MutableLiveData<String> dollarValue = new MutableLiveData<>();
    //private Float result = 0F;
    public MutableLiveData<Float> result = new MutableLiveData<>();

    public void convertValue() {
        if((dollarValue.getValue() != null)&&
                (!dollarValue.getValue().equals(""))){
            result.setValue(Float.valueOf(dollarValue.getValue())*usd_to_eu_rate);
        }else{
            result.setValue(0F);
        }
    }

//    public void setAmount(String value){
//        this.dollarText = value;
//        //result = Float.valueOf(dollarText)*usd_to_eu_rate;
//        result.setValue(Float.valueOf(dollarText)*usd_to_eu_rate);
//    }
//    //public Float getResult(){
//    public MutableLiveData<Float> getResult(){
//        return result;
//    }
}
