package com.example.assignmentu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    //private int or = getResources().getConfiguration().orientation; not necessary
    private static final int Request = 1; //Used for requesting permission
    TextView phoneNumber;
    Button btn1, btn2, btn3,btn4,btn5,btn6,btn7,btn8,btn9, btnAst,btn0,btnHash;
    FloatingActionButton btnDel, call_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.numberOne);
        btn2 = findViewById(R.id.numberTwo);
        btn3 = findViewById(R.id.numberThree);
        btn4 = findViewById(R.id.numberFour);
        btn5 = findViewById(R.id.numberFive);
        btn6 = findViewById(R.id.numberSix);
        btn7 = findViewById(R.id.numberSeven);
        btn8 = findViewById(R.id.numberEight);
        btn9 = findViewById(R.id.numberNine);
        btnAst = findViewById(R.id.asterixKey);
        btn0 = findViewById(R.id.numberZero);
        btnHash = findViewById(R.id.hashKey_);
        btnDel = findViewById(R.id.DeleteNumber_);
        phoneNumber = findViewById(R.id.NumberAppearHere);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText().toString() + "1");

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText().toString() + "2");

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText() + "3");

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText() + "4");

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText() + "5");

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText() + "6");

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText() + "7");

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText() + "8");

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText() + "9");

            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText() + "0");

            }
        });
        btnHash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText() + "#");

            }
        });
        btnAst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText() + "*");

            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Put string minus last digit back into TextView
                String temp = phoneNumber.getText().toString();
                if (!TextUtils.isEmpty(temp))
                    temp = temp.substring(0, temp.length() - 1);
                phoneNumber.setText(temp);
            }
        });
        //if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) { //Initially thought I had to make a seperate layout for landscape
         //   setContentView(R.layout.activity_main);                                               //Found out about layout variation and removed extra layout

        //} else {
          //  if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
          //      setContentView(R.layout.appinlandscape);
           // }
        //}


        call_Button = findViewById(R.id.callButton);
        call_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneCall();
            }
        });
        if (savedInstanceState != null) { //Will save data relating to textview in form of String (freeze text didn't work for me)
            String temp = savedInstanceState.getString("ph");
            phoneNumber.setText(String.valueOf(temp));
        }
    }

    private void PhoneCall() {
        String number = phoneNumber.getText().toString();
        if (number.trim().length() > 0) { //request permission and call
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, Request);
            } else {
                String telPart = "tel: " + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(telPart)));
            }
        }else{
                Toast.makeText(MainActivity.this, "Enter phone number ", Toast.LENGTH_SHORT).show();

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Request) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                PhoneCall();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("ph", phoneNumber.getText().toString());
    }


}
