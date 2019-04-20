package com.ashwin.application.task;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListAdapter;

import com.ashwin.application.task.Location.Pull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoationValues{

    model m;
    Activity a;
    public LoationValues(Activity a,model model) {

        this.a=a;
        this.m=model;

    }


protected String execute() {
        String url = "https://maps.googleapis.com/maps/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LocationInterface service = retrofit.create(LocationInterface.class);
    Call <Pull> call = service.getLatLng(m.getLocationFromModel());
    call.enqueue(new Callback<Pull>() {
            @Override
            public void onResponse(Call <Pull> call, Response<Pull> response) {
                try {
                    Double lat = response.body().getCandidate().get(0).getGeometry().getLocation().getLat();
                    Double lng = response.body().getCandidate().get(0).getGeometry().getLocation().getLng();
                    m.setLatToModel(lat);
                    m.setLngToModel(lng);
/*
                     Log.d("latlng",lat+""+lng);
*/
                    PlaceList placeList = new PlaceList(a,m);
                    String result =placeList.execute();
                } catch (Exception e) {
                }


            }

            @Override
            public void onFailure(Call <Pull> call, Throwable t) {
            }


        });


        return "aa";

    }



}
