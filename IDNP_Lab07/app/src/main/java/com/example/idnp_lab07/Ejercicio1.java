package com.example.idnp_lab07;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.idnp_lab07.fragments.Fragment1;
import com.example.idnp_lab07.fragments.Fragment2;
import com.example.idnp_lab07.fragments.Fragment3;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Ejercicio1 extends AppCompatActivity {

    private BottomNavigationView bnv;
    private Fragment1 f1 = new Fragment1();
    private Fragment2 f2 = new Fragment2();
    private Fragment3 f3 = new Fragment3();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        bnv = findViewById(R.id.btnNavegation);

        //establecemos el fragment que se muestre al inicio
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, f1).commit();

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //true para mostrar el elemento como el elemento seleccionado
                itemSelected(item);
                return true;
            }
        });
    }


    public void itemSelected(MenuItem item) {
        //otra forma de mostrar un fragment
        FragmentTransaction ft;
        switch (item.getItemId()){
            case R.id.op1:
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.contenedor, f1).commit();
                break;
            case R.id.op2:
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.contenedor, f2).commit();
                break;
            case R.id.op3:
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.contenedor, f3).commit();
                break;
        }
    }
}