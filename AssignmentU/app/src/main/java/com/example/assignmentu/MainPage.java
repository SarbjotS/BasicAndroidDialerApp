package com.example.assignmentu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        FloatingActionButton button = findViewById(R.id.AppButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                OpenApp();
            }
        });
    }
    public void OpenApp(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}