package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.Postulante.Postulante;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Activity_PostulanteRegistro extends AppCompatActivity {

    private static String TAG = "Activity_PostulanteRegistro";

    //para hacer un almacenamiento interno================
    private MyHelper helper;
    //===================================================

    private void resetForm(EditText form[]) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);

        for (int i = 0; i < form.length; i++) {
            form[i].setText("");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_registro);

        //para hacer un almacenamiento interno================
        helper = new MyHelper(this);
        //====================================================

        ArrayList<Postulante> registro = new ArrayList<Postulante>();
        EditText form[] = {
                findViewById(R.id.editNombres),
                findViewById(R.id.editPaterno),
                findViewById(R.id.editMaterno),
                findViewById(R.id.editFecNacimiento),
                findViewById(R.id.editColegio),
                findViewById(R.id.editCarrera),
                findViewById(R.id.editDNI)
        };

        Button btnRegistrar = (Button) findViewById(R.id.btnRegistro);

        Button btnSalir = (Button) findViewById(R.id.buttonQuit);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Registro  Exitoso
                Postulante nuevoPostulante = Postulante.createPostulante(form);

                try {
                    resetForm(form);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //para hacer un almacenamiento interno================
                helper.writeData(nuevoPostulante);
                //===================================================

                //Enviando datos del formulario al Activity_Menu
                Intent intent = new Intent(getApplicationContext(), ActivityMenu.class);
                startActivity(intent);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityMenu.class);
                startActivity(intent);
            }
        });
    }
}