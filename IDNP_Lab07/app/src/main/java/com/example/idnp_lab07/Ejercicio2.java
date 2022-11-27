package com.example.idnp_lab07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.idnp_lab07.fragments.FragmentA;
import com.example.idnp_lab07.fragments.FragmentB;

public class Ejercicio2 extends AppCompatActivity {

    private FragmentA fragmentA;
    private FragmentB fragmentB;
    private FragmentTransaction ftA;
    private FragmentTransaction ftB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();

        ftA = getSupportFragmentManager().beginTransaction();
        ftA.replace(R.id.contenedorArriba, fragmentA);
        ftA.commit();

        ftB = getSupportFragmentManager().beginTransaction();
        ftB.replace(R.id.contenedorAbajo, fragmentB);
        ftB.commit();
    }
}