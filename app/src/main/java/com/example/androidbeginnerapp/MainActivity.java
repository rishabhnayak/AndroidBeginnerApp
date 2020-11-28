package com.example.androidbeginnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //1. Initialize object
    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._7_login);
        //Hide Action Bar
        getSupportActionBar().hide();

        // find view
        button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //3. make your on method
                Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button 2 Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void button1(View view) {
        Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
    }


    public void button2(View view) {
        Toast.makeText(MainActivity.this, "Button 2 Clicked", Toast.LENGTH_SHORT).show();
    }
}