package com.ashwin.application.task;

import com.ashwin.application.task.Location.Pull1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlaceInterface {




        @GET("api/place/nearbysearch/json?sensor=true&radius=500&key=AIzaSyDf5lu6HB6l-dJ9EWnmDVtD0zWASk89iNM")
        Call<Pull1> getNearbyPlaces(@Query("keyword") String type,@Query("location") String location);



}
