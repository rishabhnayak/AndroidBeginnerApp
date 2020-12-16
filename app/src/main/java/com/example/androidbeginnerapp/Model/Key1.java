package com.example.androidbeginnerapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Key1 {

@SerializedName("subkey1")
@Expose
private String subkey1;
@SerializedName("subkey2")
@Expose
private String subkey2;
@SerializedName("subkey3")
@Expose
private String subkey3;
@SerializedName("subkey4")
@Expose
private String subkey4;

public String getSubkey1() {
return subkey1;
}

public void setSubkey1(String subkey1) {
this.subkey1 = subkey1;
}

public String getSubkey2() {
return subkey2;
}

public void setSubkey2(String subkey2) {
this.subkey2 = subkey2;
}

public String getSubkey3() {
return subkey3;
}

public void setSubkey3(String subkey3) {
this.subkey3 = subkey3;
}

public String getSubkey4() {
return subkey4;
}

public void setSubkey4(String subkey4) {
this.subkey4 = subkey4;
}

}