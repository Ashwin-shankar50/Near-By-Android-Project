package com.ashwin.application.task.Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geometry1 {

    @SerializedName("location")
    @Expose
    private Location1 location1;


    public Location1 getLocation() {
        return location1;
    }


    public void setLocation(Location location) {
        this.location1 = location1;
    }

}

