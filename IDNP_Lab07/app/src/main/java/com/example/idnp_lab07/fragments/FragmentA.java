package com.example.idnp_lab07.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.idnp_lab07.R;

//FRAGMENT QUE ENVIA
public class FragmentA extends Fragment {

    private TextView textofragmentB;

    private EditText datoenviado;
    private Button btnEnviar;

    public FragmentA(){
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        this.datoenviado = v.findViewById(R.id.textoEnviado);
        btnEnviar = (Button) v.findViewById(R.id.btnSender);

        btnEnviar.setOnClickListener(botonEvento);

        return v;
    }

    View.OnClickListener botonEvento = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //recibimos el componente de texto del fragmento B
            //con el getActivity() se pueden buscar todos los id del Activity
            //incluidos los fragments que pertenecen al activity
            textofragmentB = getActivity().findViewById(R.id.recibirTexto);

            //escribimos dentro del texto del fragmento B
            textofragmentB.setText(datoenviado.getText().toString());
        }
    };
}