package com.ashwin.application.task;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {
    ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString("name");
        String vicinity = extras.getString("vicinity");
        String rating = extras.getString("rating");

        TextView t1,t2,t3;


        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView4);

        t3=findViewById(R.id.textView3);


t1.setText(name);
t2.setText(vicinity);
t3.setText(rating);

    }


















}
