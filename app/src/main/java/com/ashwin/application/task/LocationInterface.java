package com.ashwin.application.task;

import com.ashwin.application.task.Location.Pull;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LocationInterface {
String inputtype="textquery";
String fields ="geometry";






    @GET("api/place/findplacefromtext/json?key=AIzaSyDf5lu6HB6l-dJ9EWnmDVtD0zWASk89iNM&inputtype=textquery&fields=geometry")
    Call<Pull> getLatLng(@Query("input") String input);

}
