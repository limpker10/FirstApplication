package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Clase estatica log, para imprimir en consola
        Log.i("info","Informacion"); //info
        Log.d("Debug","valor Debug"); // debug
        Log.w("warning","Valor Warning");
        Log.e("Error","Valor Error");
        Log.v("Verbose","Valor Verbose");
    }
}