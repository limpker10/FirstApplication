package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.myapplication.Postulante.AdapterPostulante;
import com.example.myapplication.Postulante.Postulante;

import java.util.ArrayList;

public class ActivityPostulanteList extends AppCompatActivity {

    private ArrayList<Postulante> listPostulantes;
    private RecyclerView recycler;

    private Button btnPostulanteSearch;
    private Button getBtnPostulanteSearchAtras;


    //intent
    ArrayList<Postulante> registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_list);

        //================================================
        MyHelper helper = new MyHelper(this);
        registro = helper.readData();
        //================================================


        btnPostulanteSearch = (Button) findViewById(R.id.btnActivityPostulanteInfoSearch);
        getBtnPostulanteSearchAtras = (Button) findViewById(R.id.btnAtrasListPost); //boton de atras
        recycler = findViewById(R.id.recyclerViewPostulantes);
        
        referenciarAdapter();
        
        btnPostulanteSearch.setOnClickListener(eventoActivityBuscar);
        getBtnPostulanteSearchAtras.setOnClickListener(eventoRetroceder);
    }

    private void referenciarAdapter() {

        recycler.setLayoutManager(new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false));

        //enviamos los datos al adaptador
        AdapterPostulante adapter = new AdapterPostulante(registro);
        //por ultimo al recycler le enviamos el adaptador
        recycler.setAdapter(adapter);
        ///===================================

    }

    View.OnClickListener eventoActivityBuscar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Enviando datos del formulario al Activity_PostulanteInfo
            Intent intent = new Intent(getApplicationContext(), ActivityPostulanteInfo.class);
            startActivity(intent);
        }
    };

    View.OnClickListener eventoRetroceder = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Enviando datos del formulario al Activity_PostulanteInfo
            Intent intent = new Intent(getApplicationContext(), ActivityMenu.class);
            startActivity(intent);
        }
    };

}