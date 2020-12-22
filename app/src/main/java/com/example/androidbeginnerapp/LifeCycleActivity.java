package com.example.androidbeginnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
//        Toast.makeText(this, "Oncreate called", Toast.LENGTH_SHORT).show();
        System.out.println("oncreate called");
    }

    @Override
    protected void onStart() {
        super.onStart();
//        Toast.makeText(this, "onstart called", Toast.LENGTH_SHORT).show();
        System.out.println("onstart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText(this, "onresume Called", Toast.LENGTH_SHORT).show();
        System.out.println("onresume called");

    }
    @Override
    protected void onPause() {
        super.onPause();
//        Toast.makeText(this, "onpause called", Toast.LENGTH_SHORT).show();
        System.out.println("onpause called");
    }
    @Override
    protected void onStop() {
        super.onStop();
//        Toast.makeText(this, "onstop called", Toast.LENGTH_SHORT).show();
        System.out.println("onstop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Toast.makeText(this, "destroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        alert();
    }


    public void alert(){
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Do you want to close this app?")
                .setConfirmText("Yes")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                        LifeCycleActivity.super.onBackPressed();
                    }
                })
                .setCancelButton("No", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                    }
                })
                .show();
    }
}