package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Postulante.Postulante;

import java.util.ArrayList;

public class ActivityMenu extends AppCompatActivity {
    private static String TAG = "ActivityMenu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnRegister = (Button) findViewById(R.id.buttonRegistrar);
        Button btnInfo = (Button) findViewById(R.id.buttonInfoPostulante);

        //boton hacia activity_PostulanteRegistro
        btnRegister.setOnClickListener(eventoPostulanteRegistro);

        //boton hacia Buscar Info del estudiante
        btnInfo.setOnClickListener(eventoPostulanteInfo);
    }
    private View.OnClickListener eventoPostulanteRegistro = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), Activity_PostulanteRegistro.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener eventoPostulanteInfo = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Enviando datos del formulario al Activity_PostulanteInfo
            Intent intent = new Intent(getApplicationContext(), ActivityPostulanteInfo.class);
            startActivity(intent);
        }
    };

}