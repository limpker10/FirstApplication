package com.example.idnp_lab07;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.idnp_lab07.fragments.Fragment1;
import com.example.idnp_lab07.fragments.Fragment2;
import com.example.idnp_lab07.fragments.Fragment3;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ejercicio1 = (Button) findViewById(R.id.btn1);
        Button ejercicio2 = (Button) findViewById(R.id.btn2);

        ejercicio1.setOnClickListener(evento1);
        ejercicio2.setOnClickListener(evento2);
    }

    private View.OnClickListener evento1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), Ejercicio1.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener evento2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), Ejercicio2.class);
            startActivity(intent);
        }
    };
}