package com.example.androidbeginnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ButtonClicker extends AppCompatActivity {

    TextView count;
    int sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_clicker);
        count=findViewById(R.id.count);
    }

    public void button(View view) {
        sum=sum+1;
        count.setText(String.valueOf(sum));
    }

}