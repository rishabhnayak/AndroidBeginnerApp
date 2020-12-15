package com.example.androidbeginnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androidbeginnerapp.Model.TestModel;
import com.google.gson.Gson;

public class ApiActivity extends AppCompatActivity {

    TextView name,surname;


    String api="{ \"name\": \"abc\", \"surname\":\"Rishabh\" }";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        name=findViewById(R.id.name);
        surname=findViewById(R.id.surname);

        Gson gson= new Gson();
        TestModel testModel=gson.fromJson(api,TestModel.class);

        name.setText(testModel.getName());
        surname.setText(testModel.getSurname());

    }
}



/*
{
        "name": "Rishabh",
        "surname":"nayak",
        "address":"abc,xyz",
        "pincode":"123456"
}*/
