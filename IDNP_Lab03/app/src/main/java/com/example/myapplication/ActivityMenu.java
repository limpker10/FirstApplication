package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ActivityMenu extends AppCompatActivity {
    private static String TAG = "ActivityMenu";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ArrayList<Postulante> registro = new ArrayList<Postulante>();
        //Rebiendo dato enviado desde Activity_PostulanteRegistro
        Postulante nP = (Postulante) getIntent().getSerializableExtra("dato");
        registro.add(nP);
        Log.d(TAG,"valida"+registro.toString());
        Button btnRegister = (Button) findViewById(R.id.buttonRegistrar);
        Button btnInfo = (Button) findViewById(R.id.buttonInfoPostulante);

        //boton hacia activity_PostulanteRegistro
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_PostulanteRegistro.class);
                startActivity(intent);
            }
        });

        //boton hacia Buscar Info del estudiante
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Enviando datos del formulario al Activity_PostulanteInfo
                Intent intent = new Intent(getApplicationContext(), ActivityPostulanteInfo.class);
                intent = intent.putExtra("lista",registro);
                startActivity(intent);
            }
        });
    }
}