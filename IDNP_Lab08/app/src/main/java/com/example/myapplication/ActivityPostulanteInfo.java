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
    EditText buscarTexto;
    TextView txtDNI;
    TextView txtNombres;
    TextView txtApellidos;
    TextView txtFechaN;
    TextView txtColegio;
    TextView txtCarrera;

    Button btnBuscar;
    Button btnAtras;

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
        txtDNI = findViewById(R.id.textDNI);
        txtNombres = findViewById(R.id.textNombres);
        txtApellidos = findViewById(R.id.textApellidos);
        txtFechaN = findViewById(R.id.textFN);
        txtColegio = findViewById(R.id.textColegio);
        txtCarrera = findViewById(R.id.textCarrera);

        btnBuscar = (Button) findViewById(R.id.botonbuscar);
        btnAtras = (Button) findViewById(R.id.botonAtras);

        btnBuscar.setOnClickListener(eventoCargarDatosPostulante);
        btnAtras.setOnClickListener(eventoAtras);

    }

    private View.OnClickListener eventoCargarDatosPostulante = new View.OnClickListener() {
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
    };

    private View.OnClickListener eventoAtras = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), ActivityPostulanteList.class);
            startActivity(intent);
        }
    };
}