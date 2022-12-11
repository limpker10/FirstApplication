package com.example.myapplication.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.MyHelper;
import com.example.myapplication.Postulante.AdapterPostulante;
import com.example.myapplication.Postulante.Postulante;
import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentListPostulante#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentListPostulante extends Fragment {

    private RecyclerView recycler;
    private ArrayList<Postulante> registro;
    private ArrayList<Postulante> listPostulantesBuscados;

    private static final String ARG_PARAM = "buscarPostulante";
    private String textoBuscarPostulante = "";

    public FragmentListPostulante() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentListPostulante newInstance(String textoBuscar) {
        FragmentListPostulante fragment = new FragmentListPostulante();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, textoBuscar);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            textoBuscarPostulante = getArguments().getString(ARG_PARAM);
            Toast.makeText(getActivity(), textoBuscarPostulante, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_postulante,
                container, false);

        recycler = view.findViewById(R.id.recyclerViewPostulantes);
        referenciarAdapter();
        return view;
    }

    public void referenciarAdapter() {
        //================================================
        //almacenamiento interno
        MyHelper helper = new MyHelper(getActivity());
        registro = helper.readData(); //carga todos los postulantes
        //================================================
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(),
                RecyclerView.VERTICAL, false));

        //enviamos los datos al adaptador
        AdapterPostulante adapter = new AdapterPostulante(registro);

        //por ultimo al recycler le enviamos el adaptador
        recycler.setAdapter(adapter);
    }

    public void recibirInfo(String dni){
        //buscando postulantes luego de presionar boton
        listPostulantesBuscados = new ArrayList<>();
        for (int i = 0; i < registro.size(); i++) {
            if (dni.equals(registro.get(i).dni)) {
                listPostulantesBuscados.add(registro.get(i));
            }
        }
        AdapterPostulante adapter = new AdapterPostulante(listPostulantesBuscados);
        //por ultimo al recycler le enviamos el adaptador
        recycler.setAdapter(adapter);
    }
}