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

    //para hacer un almacenamiento interno================
    //para poder ver el recycler view
    private MyHelper helper;
    //===================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //para hacer un almacenamiento interno================
        //para poder ver el recycler view
        helper = new MyHelper(this);
        Postulante nuevoPostulante = null;

        llenarDatosEnAlmacenamientoInterno();
        //====================================================

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
                Intent intent = new Intent(getApplicationContext(), ActivityPostulanteList.class);
                startActivity(intent);
            }
        });
    }

    private void llenarDatosEnAlmacenamientoInterno() {

        helper.writeData(new Postulante("Luis", "Condori",
                "Villalba", "0",
                "publico", "Ingeneria de Sistemas", "01/01/01"));

        helper.writeData(new Postulante("Alex", "Condori",
                "Villalba", "01/01/01",
                "publico", "Ingeneria de Sistemas", "1"));

        helper.writeData(new Postulante("Juan", "Condori",
                "Villalba", "01/01/01",
                "publico", "Ingeneria de Sistemas", "2"));

        helper.writeData(new Postulante("Gilbert", "Condori",
                "Villalba", "01/01/01",
                "publico", "Ingeneria de Sistemas", "3"));

        helper.writeData(new Postulante("Adan", "Condori",
                "Villalba", "01/01/01",
                "publico", "Ingeneria de Sistemas", "4"));

        helper.writeData(new Postulante("Moises", "Condori",
                "Villalba", "01/01/01",
                "publico", "Ingeneria de Sistemas", "5"));

        helper.writeData(new Postulante("Antonio", "Condori",
                "Villalba", "01/01/01",
                "publico", "Ingeneria de Sistemas", "6"));

    }
}