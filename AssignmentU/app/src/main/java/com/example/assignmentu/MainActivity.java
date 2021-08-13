package com.example.assignmentu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private int or = getResources().getConfiguration().orientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (or == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_main);
        }else{
            setContentView(R.layout.appinlandscape);
            ;
        }

        
    }
}