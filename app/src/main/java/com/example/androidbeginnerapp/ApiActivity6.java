package com.example.androidbeginnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidbeginnerapp.Model.ImageData;
import com.example.androidbeginnerapp.Model.MainData2;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class ApiActivity6 extends AppCompatActivity {

    ImageView imageView;
    String imageurl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api6);

        imageView=findViewById(R.id.apiimage);
        fetchData();
    }

    public void fetchData(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://raysapps.in/api.php" , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println("This is response :"+response);

                Gson gson=new Gson();

                ImageData imageData=gson.fromJson(response,ImageData.class);
                imageurl = imageData.getImage_url();
                System.out.println(imageurl);
                Picasso.get()
                        /*load image*/        .load(imageurl)
                        /*set placeholder*/        .placeholder(getResources().getDrawable(R.drawable.background))
                        /*set error image*/       .error(getResources().getDrawable(R.drawable.background2))
                        .into(imageView);
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