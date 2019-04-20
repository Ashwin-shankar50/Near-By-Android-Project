package com.ashwin.application.task;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;

import static android.util.Log.d;


public class MainActivity extends AppCompatActivity {


    ListView listPlace;
    ConstraintLayout constraintLayout;
    ArrayList <HashMap <String, String>> dataList = new ArrayList <HashMap <String, String>>();
    Activity a = MainActivity.this;
    HashMap <String, String> map = new HashMap <String, String>();
    model m = new model();
EditText et1;
Spinner sp1;

    int mile = 0;
    ProgressDialog progressBar;
    PlaceList placeList = new PlaceList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listPlace = (ListView) findViewById(R.id.listPlace);
        constraintLayout = findViewById(R.id.rel);
        Log.d("life", "The onStart() event");

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboardFrom(getApplicationContext(), v);
            }
        });
        final ProgressBar spinner;
        final Activity a = MainActivity.this;
        listPlace = (ListView) findViewById(R.id.listPlace);
        final ProgressBar pbHeaderProgress = (ProgressBar) findViewById(R.id.pbHeaderProgress);
et1=findViewById(R.id.Location);
sp1=findViewById(R.id.spinner);


        final Button b = findViewById(R.id.button);

Log.d("mile", String.valueOf(mile));
        pbHeaderProgress.setVisibility(View.INVISIBLE);


            ListAdapter adapter = new ListAdapter(MainActivity.this, m.getModelList());

            listPlace.setAdapter(adapter);



        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                m.setLocationToModel(et1.getText().toString());
                m.setPlaceToModel(sp1.getSelectedItem().toString());
if(et1.getText().toString().equals(""))
{
    Toast toast=Toast.makeText(getApplicationContext(),"Enter any location",Toast.LENGTH_SHORT);
    toast.show();
}
else {
    hideKeyboardFrom(getApplicationContext(), v);

    LoationValues loationValues = new LoationValues(a, m);
                String result = loationValues.execute();


                pbHeaderProgress.setVisibility(View.VISIBLE);
                b.setVisibility(View.GONE);


                Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    public void run() {


                        ListAdapter adapter = new ListAdapter(MainActivity.this, m.getModelList());

                        listPlace.setAdapter(adapter);
                        pbHeaderProgress.setVisibility(View.GONE);
                        b.setVisibility(View.VISIBLE);

                    }
                }, 5000);

}

        }

        });
        listPlace.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                int i = position;

                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                Bundle extras = new Bundle();
                extras.putString("name", m.getModelList().get(i).get("name"));
                extras.putString("vicinity", m.getModelList().get(i).get("vicinity"));
                extras.putString("rating", m.getModelList().get(i).get("rating"));

                intent.putExtras(extras);
                startActivity(intent);
            }

        });

    }

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


}
