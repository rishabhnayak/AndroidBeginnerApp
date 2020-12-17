package com.example.androidbeginnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidbeginnerapp.Model.ApiData;
import com.google.gson.Gson;

public class ApiActivity3 extends AppCompatActivity {

    TextView name,surname;
    EditText password;
    String apipassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api3);

        name=findViewById(R.id.name);
        surname=findViewById(R.id.surname);
        password=findViewById(R.id.password);


        fetchResponse();
    }


    public void fetchResponse(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://raysapps.in/api.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println("this is response : "+response);
                Gson gson=new Gson();

                ApiData apiData=gson.fromJson(response,ApiData.class);

                name.setText(apiData.getName());
                surname.setText(apiData.getSurname());

                apipassword=apiData.getPassword();

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


    public void submit(View view) {
        if (apipassword.equals(password.getText().toString())){
            Toast.makeText(this, "Password Correct", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Password Incorrect", Toast.LENGTH_SHORT).show();
        }
    }
}