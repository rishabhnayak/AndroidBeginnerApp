package com.example.androidbeginnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SwitchActivity extends AppCompatActivity {
    Switch toggle;
    TextView toggleText;
    ImageView imageView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._9_activity_switch);

        getSupportActionBar().hide();

        toggle=findViewById(R.id.toggle_switch);
        toggleText=findViewById(R.id.toggle_text);
        imageView=findViewById(R.id.background);
        editText=findViewById(R.id.name);


        imageView.setBackground(getResources().getDrawable(R.drawable.background2));
        toggleText.setText("Demo Toggle switch OFF");
        toggleText.setTextColor(getResources().getColor(R.color.white));

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b==true){
                    functionOn();
                }else {
                    functionOff();
                }

            }
        });

    }


    public void functionOn(){
        toggleText.setText("Demo Toggle switch ON");
//        imageView.setVisibility(View.VISIBLE);
          imageView.setBackground(getResources().getDrawable(R.drawable.background));
          toggleText.setTextColor(getResources().getColor(R.color.black));
    }
    public void functionOff(){
        toggleText.setText("Demo Toggle switch OFF");
//        imageView.setVisibility(View.INVISIBLE);
        imageView.setBackground(getResources().getDrawable(R.drawable.background2));
        toggleText.setTextColor(getResources().getColor(R.color.white));
    }

    public void getMethodsEdittext(){

    }

}