package com.example.laboratorio01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;


public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("info","Informacion"); //info
        Log.d("Debug","valor Debug"); // debug
        Log.w("warning","Valor Warning");
        Log.e("Error","Valor Error");
        Log.v("Verbose","Valor Verbose");
    }
}