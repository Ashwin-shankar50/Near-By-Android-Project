package com.ashwin.application.task;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.HashMap;

public class ListAdapter extends BaseAdapter {
    ImageView galleryImage;
    TextView title, sdetails;
    private Activity  activity;
    private ArrayList<HashMap<String, String>> data;

    public ListAdapter( Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ListNewsViewHolder holder;
        if (view == null) {
            holder = new ListNewsViewHolder();
            view = LayoutInflater.from(activity).inflate(
                    R.layout.list_row, viewGroup, false);
            holder.title = (TextView) view.findViewById(R.id.title);
            view.setTag(holder);
        } else {
            holder = (ListNewsViewHolder) view.getTag();
        }
        holder.title.setId(i);
        HashMap<String, String> news = new HashMap<String, String>();
        news = data.get(i);
        try{
            holder.title.setText(news.get("name"));

        }
        catch(Exception e) {}
        return view;

    }
}

class ListNewsViewHolder {

    TextView title, sdetails;
}