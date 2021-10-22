package com.example.calculatorlibraary;

import androidx.lifecycle.MutableLiveData;

import com.example.arthimetic.Arthimetic;


public class CalciPresenter extends Arthimetic {
    String input="";
    public MutableLiveData<String> inputResult = new MutableLiveData<String>();
    public MutableLiveData<String> outputResult = new MutableLiveData<String>();

    public void onothers(final String data) {
        input=input+data;
        result1.postValue(input);
    }
    public void onequals(final String data) {
        if(data.contains("+")){
            String str[] = data.split("\\+");
            float a=Float.parseFloat(str[0]);
            float b=Float.parseFloat(str[1]);
            outputResult.postValue(String.valueOf(Arthimetic.Add(a,b)));
        }
        else if(data.contains("-")){
            String str[] = data.split("\\-");
            float a=Float.parseFloat(str[0]);
            float b=Float.parseFloat(str[1]);
            outputResult.postValue(String.valueOf(Arthimetic.sub(a,b)));
        }
        else if(data.contains("*")){
            String str[] = data.split("\\*");
            float a=Float.parseFloat(str[0]);
            float b=Float.parseFloat(str[1]);
            outputResult.postValue(String.valueOf(Arthimetic.mul(a,b)));
        }
        else if(data.contains("/")){
            String str[] = data.split("\\/");
            float a=Float.parseFloat(str[0]);
            float b=Float.parseFloat(str[1]);
            outputResult.postValue(String.valueOf(Arthimetic.div(a,b)));
        }
    }
}
