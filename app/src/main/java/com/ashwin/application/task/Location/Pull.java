package com.ashwin.application.task.Location;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
public class Pull {
    @SerializedName("candidates")
    @Expose
    private List<Candidates> candidate = new ArrayList<Candidates>();

    @SerializedName("status")
    @Expose
    private String status;


    public List <Candidates> getCandidate() {
        return candidate;
    }





    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }
}
