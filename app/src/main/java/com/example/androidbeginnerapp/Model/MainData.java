package com.example.androidbeginnerapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainData {

@SerializedName("key1")
@Expose
private Key1 key1;

public Key1 getKey1() {
return key1;
}

public void setKey1(Key1 key1) {
this.key1 = key1;
}

}