package com.example.androidbeginnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {

    RadioGroup radioGroup;

    RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._10_activity_radio_button);

        radioGroup=findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectedId=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(selectedId);
                Toast.makeText(getApplicationContext(), radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}