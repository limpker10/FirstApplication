package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.Fragments.FragmentListPostulante;
import com.example.myapplication.Fragments.FragmentPostulanteNoEncontrado;
import com.example.myapplication.Postulante.Postulante;

import java.util.ArrayList;

public class ActivityPostulanteInfo extends AppCompatActivity {

    FragmentListPostulante fragmentListPostulante = new FragmentListPostulante();
    FragmentPostulanteNoEncontrado fragmentPostulanteNoEncontrado = new FragmentPostulanteNoEncontrado();

    ArrayList<Postulante> registro;

    Button btnBuscar;
    Button btnAtras;
    EditText buscarTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_info);

        // Recibiendo lista de postulantes
        //================================================
        MyHelper helper = new MyHelper(this);
        registro = helper.readData();
        //================================================

        buscarTexto = findViewById(R.id.editTextSearch);

        btnBuscar = (Button) findViewById(R.id.botonbuscar);
        btnAtras = (Button) findViewById(R.id.botonAtras);

        btnBuscar.setOnClickListener(eventoCargarDatosPostulante);
        btnAtras.setOnClickListener(eventoAtras);

        //cargando fragment
        getSupportFragmentManager().beginTransaction().replace(
                R.id.containerFragmentPostulante,fragmentListPostulante
        ).commit();

    }

    private View.OnClickListener eventoCargarDatosPostulante = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(buscarTexto.getText().toString().equals("")){
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.containerFragmentPostulante, fragmentListPostulante
                ).commit();
            }else{
                for (int i = 0; i < registro.size(); i++) {

                    if (buscarTexto.getText().toString().equals(registro.get(i).dni)) {
                        //enviamos dni al fragment.............
                        fragmentListPostulante.recibirInfo(buscarTexto.getText().toString());
                        break;
                    }

                    if (i == registro.size() - 1) {
                        getSupportFragmentManager().beginTransaction().replace(
                                R.id.containerFragmentPostulante, fragmentPostulanteNoEncontrado
                        ).commit();

                    }
                }
            }

        }
    };

    private View.OnClickListener eventoAtras = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), ActivityMenu.class);
            startActivity(intent);
        }
    };
}