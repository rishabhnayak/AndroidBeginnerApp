package com.example.androidbeginnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidbeginnerapp.Model.MainData2;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ApiActivity5 extends AppCompatActivity {
    ListView list;
    String url;

    List<String> mainList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api5);
        list=findViewById(R.id.list);
        url="https://raysapps.in/api2.php";
        mainList=new ArrayList<String>();
        fetchData();
    }

    public void fetchData(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ApiActivity5.this, ""+response, Toast.LENGTH_SHORT).show();
                System.out.println("this is response : "+response);
                Gson gson=new Gson();

                MainData2 mainData2=gson.fromJson(response,MainData2.class);

                for (int i=0;i<mainData2.getAlphabet().size();i++){
                    mainList.add(mainData2.getAlphabet().get(i));
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ApiActivity5.this, android.R.layout.simple_list_item_1,mainList);
                list.setAdapter(adapter);

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

}