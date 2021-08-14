package com.example.assignmentu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //private int or = getResources().getConfiguration().orientation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);

        }else{
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                setContentView(R.layout.appinlandscape);
            }



        }
    //public void onConfigurationChanged(Configuration or){
      //  super.onConfigurationChanged(or);
       // if (or.orientation == Configuration.ORIENTATION_LANDSCAPE){
       //     setContentView(R.layout.appinlandscape);
       // }
    }
}