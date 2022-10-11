package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Postulante> registro = new ArrayList<Postulante>();

        EditText edtNombres = findViewById(R.id.editNombres);
        EditText edtPaterno = findViewById(R.id.editPaterno);
        EditText edtMaterno = findViewById(R.id.editMaterno);
        EditText edtFecNaci = findViewById(R.id.editFecNacimiento);
        EditText edtColegio = findViewById(R.id.editColegio);
        EditText edtCarrera = findViewById(R.id.editCarrera);
        TextView txtMensaje = findViewById(R.id.txtMensaje);
        Button btnRegistrar = (Button) findViewById(R.id.btnRegistro);
        Button btnVerLista = (Button) findViewById(R.id.btnListaPostulantes);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMensaje.setText("Registro  Exitoso");
                registro.add(new Postulante(edtNombres,edtPaterno,edtMaterno,edtFecNaci,edtColegio,edtCarrera));
            }
        });
        btnVerLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0;i<registro.size();i++) {

                    Log.d(TAG,"valida," + registro.get(i) );
                }
            }
        });


        /**
        EditText edtUsuario = findViewById(R.id.edtUsuario);
        EditText edtPassword = findViewById(R.id.edtPassword);
        TextView txtMensaje = findViewById(R.id.txtMensaje);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = edtUsuario.getText().toString();
                String password = edtPassword.getText().toString();
                if (usuario.equals("test") && password.equals("1234")) {
                    Log.d(TAG,"valida," + usuario + "," + password);
                    txtMensaje.setText("Autenticacion valida");
                } else {
                    txtMensaje.setText("Autenticacion no valida");
                    Log.d(TAG,"invalido," + usuario + "," + password);
                }
            }
        });


        Clase estatica log, para imprimir en consola
        Log.i("info","Informacion"); //info
        Log.d("Debug","valor Debug"); // debug
        Log.w("warning","Valor Warning");
        Log.e("Error","Valor Error");
        Log.v("Verbose","Valor Verbose");

         */
    }
}