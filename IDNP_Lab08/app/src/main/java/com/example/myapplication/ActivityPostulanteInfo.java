package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.Postulante.Postulante;

import java.util.ArrayList;

public class ActivityPostulanteInfo extends AppCompatActivity {

    ArrayList<Postulante> registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_info);

        // Recibiendo lista de postulantes
        //================================================
        MyHelper helper = new MyHelper(this);
        registro = helper.readData();

        //================================================

        EditText buscarTexto = findViewById(R.id.editTextSearch);
        TextView txtDNI = findViewById(R.id.textDNI);
        TextView txtNombres = findViewById(R.id.textNombres);
        TextView txtApellidos = findViewById(R.id.textApellidos);
        TextView txtFechaN = findViewById(R.id.textFN);
        TextView txtColegio = findViewById(R.id.textColegio);
        TextView txtCarrera = findViewById(R.id.textCarrera);

        Button btnBuscar = (Button) findViewById(R.id.botonbuscar);
        Button btnAtras = (Button) findViewById(R.id.botonAtras);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < registro.size(); i++) {
                    if (buscarTexto.getText().toString().equals(registro.get(i).dni)) {
                        txtDNI.setText(txtDNI.getText() + registro.get(i).dni);
                        txtApellidos.setText(txtApellidos.getText() + registro.get(i).edtPaterno + ' ' + registro.get(i).edtMaterno);
                        txtFechaN.setText(txtFechaN.getText() + registro.get(i).edtFecNacimiento);
                        txtNombres.setText(txtNombres.getText() + registro.get(i).edtNombres);
                        txtCarrera.setText(txtCarrera.getText() + registro.get(i).edtCarrera);
                        txtColegio.setText(txtColegio.getText() + registro.get(i).edtColegio);
                        break;
                    }
                    if (i == registro.size() - 1) {
                        txtDNI.setText("DNI: ");
                        txtApellidos.setText("Apellidos: ");
                        txtFechaN.setText("Fecha de Nacimiento: ");
                        txtNombres.setText("Nombres: ");
                        txtCarrera.setText("Carrera: ");
                        txtColegio.setText("Colegio: ");
                    }
                }
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityPostulanteList.class);
                startActivity(intent);
            }
        });
    }
}