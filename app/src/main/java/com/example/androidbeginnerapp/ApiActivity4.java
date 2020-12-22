package com.example.androidbeginnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidbeginnerapp.Model.MainData;
import com.example.androidbeginnerapp.Model.MainData2;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ApiActivity4 extends AppCompatActivity {
    String url;
    Spinner spinner;

    List<String> alphabet;
    String selectedValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api4);
        spinner=findViewById(R.id.spinner);
        alphabet=new ArrayList<>();
        url="https://raysapps.in/api2.php";
        fetchData();
    }

    public void fetchData(){
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url , new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    Gson gson=new Gson();

                    MainData2 mainData2=gson.fromJson(response, MainData2.class);

                    for (int i=0;i<mainData2.getAlphabet().size();i++){
                        System.out.println(mainData2.getAlphabet().get(i));
                        alphabet.add(mainData2.getAlphabet().get(i));
                    }
                    //spinner adapter
                    ArrayAdapter adapter = new ArrayAdapter(ApiActivity4.this,R.layout.itemtext,alphabet);
                    adapter.setDropDownViewResource(R.layout.itemtextlayout);
                    spinner.setAdapter(adapter);

                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            selectedValue=alphabet.get(i);
                            SelectedValue();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println(error.getMessage());
                }
            });

            RequestQueue queue= Volley.newRequestQueue(this);
            queue.add(stringRequest);
    }

    public void SelectedValue(){
        Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
    }

}