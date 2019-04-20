package com.ashwin.application.task.Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Candidates {


    @SerializedName("geometry")
    @Expose
    private Geometry geometry;
    public Geometry getGeometry() {
        return geometry;
    }

    /**
     *
     * @param geometry
     * The geometry
     */
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    }


