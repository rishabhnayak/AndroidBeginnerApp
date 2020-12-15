package com.example.androidbeginnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity {
    Spinner spinner;

    String[] city={"Raipur","Tilda","Bilaspur","Durg"};

    String selectedValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner =  findViewById(R.id.spinner);

        //spinner adapter
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,city);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedValue=city[i];
                SelectedValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


// delay timer
//        Handler handler=new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                SelectedValue();
//            }
//        },5000);

    }


    public void SelectedValue(){
        Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
    }

}