package com.ashwin.application.task;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.ListView;

import com.ashwin.application.task.Location.Pull1;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceList
{
       ArrayList<HashMap<String,String>> dataList = new ArrayList<HashMap<String,String>>();

    ListView listPlace;
Activity a;
model m;
Boolean status=false;
    public PlaceList(Activity a,model model) {
     this.m=model;
     this.a=a;
    }

    public PlaceList() {

    }



    protected String execute() {
/*
        Log.d("DOINBACKGROUND","YES");
*/
        String url = "https://maps.googleapis.com/maps/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PlaceInterface service = (PlaceInterface) retrofit.create(PlaceInterface.class);
        Call<Pull1> call1 = service.getNearbyPlaces(m.getPlaceFromModel(),m.getLatFromModel()+","+m.getLngFromModel());

        call1.enqueue(new Callback<Pull1>() {

            @Override
            public void onResponse(Call <Pull1> call, Response <Pull1> response) {
              /*status=  response.isSuccessful();*/
/*
                Log.d("ONRESPONSE","YES");
*/
                for (int i = 0; i < response.body().getResults().size(); i++) {
                    try {
                        String rating=response.body().getResults().get(i).getRating().toString();
                        String placeName = response.body().getResults().get(i).getName();
                        String vicinity = response.body().getResults().get(i).getVicinity();


                        HashMap<String,String> map= new HashMap <>();
                        map.put("name", placeName);
                        map.put("vicinity", vicinity);
                        map.put("rating",rating);
                        dataList.add(i,map);
                     /*   Log.d("map", String.valueOf(map));
                        Log.d("List",dataList.toString());*/
                    }catch (Exception e){
                        throw e;
                    }

                }
            }


            @Override
            public void onFailure(Call <Pull1> call, Throwable t) {

            }
        });

//        Log.d("map", String.valueOf(dataList));

       m.setModelList(dataList);
//        Log.d("data", String.valueOf(dataList));


        return "as";
    }



}
