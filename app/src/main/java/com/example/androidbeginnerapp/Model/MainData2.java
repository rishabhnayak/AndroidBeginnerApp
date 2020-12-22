package com.example.androidbeginnerapp.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainData2 {

@SerializedName("alphabet")
@Expose
private List<String> alphabet = null;

public List<String> getAlphabet() {
return alphabet;
}

public void setAlphabet(List<String> alphabet) {
this.alphabet = alphabet;
}

}