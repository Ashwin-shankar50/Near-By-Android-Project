package com.ashwin.application.task;

import java.util.ArrayList;
import java.util.HashMap;

public class model {
    ArrayList<HashMap<String,String>> modelList = new ArrayList <HashMap<String, String>>();
    String location,place;
    Double lat,lng;


    Double getLatFromModel(){
        return this.lat;
    }

    Double getLngFromModel(){
        return this.lng;
    }

    String getLocationFromModel(){
        return this.location;
    }

    String getPlaceFromModel(){
        return this.place;
    }

    ArrayList<HashMap<String,String>> getModelList(){
        return this.modelList;
    }


    void setLocationToModel(String location){
        this.location=location;
    }

    void setPlaceToModel(String place){
        this.place=place;
    }

    void setLatToModel(Double lat){
        this.lat=lat;
    }

    void setLngToModel(Double lng){
        this.lng=lng;
    }

    void setModelList(ArrayList<HashMap<String,String>> dataList){
        this.modelList=dataList;

    }
    void setModelList1(HashMap<String,String> map){
        this.modelList.add(map);

    }

}
