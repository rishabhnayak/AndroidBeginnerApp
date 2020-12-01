package com.example.androidbeginnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextActivity extends AppCompatActivity {

    EditText nameedittext,passwordedittext;
    Button button;
    String name,password;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor myEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._8_edittext);
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        myEdit = sharedPreferences.edit();
//      //add cache
//        myEdit.putString("name","rishabh");
//        myEdit.commit();
//
//        //get cache
//      name =  sharedPreferences.getString("name",null);

        getSupportActionBar().hide();
        inti();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValue();
            }
        });


       String dataavail =  sharedPreferences.getString("name","null");

       if (dataavail.equals("null")){
           Toast.makeText(this, "cache not avail", Toast.LENGTH_SHORT).show();
       }else {
           Intent intent=new Intent(getApplicationContext(),MainActivity.class);
           startActivity(intent);
           finish();
       }



    }

    public void inti(){
        nameedittext=findViewById(R.id.name);
        passwordedittext=findViewById(R.id.password);
        button=findViewById(R.id.button);
    }

    public void getValue(){
        name = nameedittext.getText().toString();
        password= passwordedittext.getText().toString();

        if (name.equals("rishabh")&&password.equals("12345")){
            Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show();

            myEdit.putString("name",name);
            myEdit.putString("password",password);
            myEdit.commit();

            //intent
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            intent.putExtra("name",name);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "incorrect password", Toast.LENGTH_SHORT).show();
        }




    }

}