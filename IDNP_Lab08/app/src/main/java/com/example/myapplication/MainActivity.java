package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.Postulante.Postulante;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";

    EditText edtUsuario;
    EditText edtPassword;
    TextView txtMensaje;
    Button btnLogin;

    //para hacer un almacenamiento interno================
    //para poder ver el recycler view
    private MyHelper helper;
    //===================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //para hacer un almacenamiento interno================
        //para poder ver el recycler view
        helper = new MyHelper(this);
        //llenamos datos predeterminados
        llenarDatosEnAlmacenamientoInterno();
        //====================================================

        edtUsuario = findViewById(R.id.edtUsuario);
        edtPassword = findViewById(R.id.edtPassword);
        txtMensaje = findViewById(R.id.txtMensaje);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        //evento
        btnLogin.setOnClickListener(eventoAutenticacion);


    }

    private View.OnClickListener eventoAutenticacion= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String usuario = edtUsuario.getText().toString();
            String password = edtPassword.getText().toString();
            if (usuario.equals("admin") && password.equals("1234")) {
                Log.d(TAG,"valida," + usuario + "," + password);
                txtMensaje.setText("Autenticacion valida");

                Intent intent = new Intent(getApplicationContext(), ActivityMenu.class);
                startActivity(intent);

            } else {
                txtMensaje.setText("Autenticacion no valida");
                Log.d(TAG,"invalido," + usuario + "," + password);
            }
        }
    };


    private void llenarDatosEnAlmacenamientoInterno() {

        helper.writeData(new Postulante("Luis", "Condori",
                "Villalba", "01/01/01",
                "publico", "Ingeneria de Sistemas", "0"));

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