package com.example.androidbeginnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androidbeginnerapp.Model.MainData;
import com.google.gson.Gson;

public class ApiActivity2 extends AppCompatActivity {
    String api="{\n" +
            "   \"key1\":{\n" +
            "      \"subkey1\":\"Carrot\",\n" +
            "      \"subkey2\":\"banana\",\n" +
            "      \"subkey3\":\"orange\",\n" +
            "      \"subkey4\":\"apple\"\n" +
            "   }\n" +
            "}";
    TextView textView;
    String data1,data2,data3,data4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api2);

        textView=findViewById(R.id.text);

        Gson gson=new Gson();

        MainData mainData=gson.fromJson(api,MainData.class);
        data1=mainData.getKey1().getSubkey1();
        data2=mainData.getKey1().getSubkey2();
        data3=mainData.getKey1().getSubkey3();
        data4=mainData.getKey1().getSubkey4();

        textView.setText(data1+" "+data2+" "+data3+" "+data4);

    }
}